package com.algerage.booking.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.core.importer.Location;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.algerage.booking")
public class NamingConventionTest {

    static ImportOption ignoreTest =
            new ImportOption() {
                @Override
                public boolean includes(Location location) {
                    return !location.contains("/test-classes/");
                }
            };

    private static final JavaClasses classes =
            new ClassFileImporter().withImportOption(ignoreTest).importPackages("com.algerage.booking");

    @ArchTest
    public static final ArchRule classesInPortPackageShouldEndWithPort =
            classes()
                    .that()
                    .resideInAnyPackage(
                            "com.algerage.booking.application.port.*",
                            "com.algerage.booking.application.port.out")
                    .should()
                    .haveSimpleNameEndingWith("Port");

    @Test
    public void runArchUnitTests() {
        classesInPortPackageShouldEndWithPort.check(classes);
    }
}