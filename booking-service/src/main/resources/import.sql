INSERT INTO USERS (user_id, name, login, last_name, surname, email, telephone) VALUES (1,'John', 'doe', 'Doe', 'Smith', 'john.doe@email.com', '123456789');
INSERT INTO ADDRESSES (address_id, street, postcode, city, country) VALUES (1,'Main Street', '12345', 'New York', 'USA');

INSERT INTO USERS_ADDRESSES (user_id, address_id) VALUES (1, 1);
INSERT INTO CLIENTS (client_id, razon, cod_documento, telefono, fecha_alta, fecha_baja, logo) VALUES (1, 'Ayuntamiento Casinos', '12345678A', '123456789', CURRENT_TIMESTAMP(), null, null);

INSERT INTO SERVICES (service_id, client_id, name, duration, price) VALUES (1, 1, 'Pista padel', 60, 10.0);

INSERT INTO BOOKING_STATUS(booking_status_id, status) VALUES (1, 'PENDING');
INSERT INTO BOOKING_STATUS(booking_status_id, status) VALUES (2, 'CONFIRMED');
INSERT INTO BOOKING_STATUS(booking_status_id, status) VALUES (3, 'CANCELLED');


-- DATA DEMO - BEGIN
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (1, 1, 'MONDAY', '08:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (2, 1, 'TUESDAY', '09:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (3, 1, 'WEDNESDAY', '10:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (4, 1, 'THURSDAY', '11:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (5, 1, 'FRIDAY', '12:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (6, 1, 'SATURDAY', '13:00', '22:00');
INSERT INTO BUSINESS_HOURS (business_hours_id, service_id, weekday, start_time, end_time) VALUES (7, 1, 'SUNDAY', '14:00', '22:00');

INSERT INTO BLOCKED_TIMES(blocked_time_id, client_id, service_id, weekday, start_time, end_time) VALUES (1, 1, 1, 'MONDAY', '2025-04-10 08:00:00', '2025-04-10 10:00:00');
INSERT INTO BLOCKED_TIMES(blocked_time_id, client_id, service_id, weekday, start_time, end_time) VALUES (2, 1, 1, 'THURSDAY', '2025-04-10 18:00:00', '2025-04-10 20:00:00');
INSERT INTO BOOKING (user_id,client_id,service_id,booking_start,booking_end,booking_status) VALUES (1,1,1,'2025-04-10 11:00:00','2025-04-10 12:00:00', 2);
-- DATA DEMO - END