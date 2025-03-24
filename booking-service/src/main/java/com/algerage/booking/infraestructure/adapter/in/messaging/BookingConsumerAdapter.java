package com.algerage.booking.infraestructure.adapter.in.messaging;

import com.algerage.booking.application.port.in.BookingConsumerPort;
import com.algerage.booking.application.port.in.RandomGeneratorPort;
import com.algerage.booking.application.port.out.BookingAckProducerPort;
import com.algerage.booking.domain.model.BookingMessage;
import com.algerage.booking.domain.model.BookingMessageAck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@RequiredArgsConstructor
public class BookingConsumerAdapter implements BookingConsumerPort {

    private final RedissonClient redissonClient;
    private final RandomGeneratorPort randomGenerator;
    private final BookingAckProducerPort bookingAckProducer;

    @Override
    @KafkaListener(id = "bookingConsumer", topics = "booking")
    public void consumeBooking(final BookingMessage message) {
        log.info("Message consumed: {}", message);
        //System.out.println("Message consumed: " + message);

        String normalizedDate = message.date().replace("/", "-");
        String normalizedTime = message.time().replace(":", "-");

        // Create the unique lock key
        String lockKey = String.format("lock:booking:%s:%s:%s",
                message.clientId(), normalizedDate, normalizedTime);

        // Obtain the lock
        RLock lock = redissonClient.getLock(lockKey);

        boolean isLocked = false;
        boolean paymentsuccess = false;
        try {
            // Try to acquire the lock (wait up to 5 seconds, auto-release after 60 seconds)
            isLocked = lock.tryLock(0, 600, TimeUnit.SECONDS);
            if (isLocked) {
                log.info("Lock acquired for: {}", lockKey);
                log.info("Processing booking: {}", message);
                bookingAckProducer.sendBookingAck(new BookingMessageAck(message, true, "Slot reserved but pending for payment"));

                int i = randomGenerator.generateRandomNumber();
                if (i % 2 == 0) {
                    log.info("Booking processed successfully: Payment was processed");
                    paymentsuccess = true;
                    //paymentProducer.sendBookingRequestToPayment(message);
                } else {
                    log.info("Booking processed with failure: Payment was NOT processed");
                }
                if (paymentsuccess) {
                    log.info("Booking processed successfully: Slot reserved");
                }

            } else {
                log.warn("Lock not acquired for: {}", lockKey);
                bookingAckProducer.sendBookingAck(new BookingMessageAck(message, false, "Slot already locked"));
            }


        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Interrupted while processing booking.");
        } finally {
            if (isLocked && lock.isHeldByCurrentThread()) {
                // Release the lock
                //lock.unlock();
                log.info("Lock released for: {}", lockKey);
                //System.out.println("Lock released for: " + lockKey);
            }
        }
    }


}
