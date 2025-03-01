package com.algerage.booking.arch;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;

@AnalyzeClasses(packages = "com.algerage.booking")
public class PackageDependencyTest {

    private static final JavaClasses classes =
            new ClassFileImporter().importPackages("com.algerage.booking");

    @ArchTest
    public static final ArchRule applicationShouldNotDependOnInfrastructure =
            noClasses()
                    .that()
                    .resideInAPackage("..application..")
                    .should()
                    .dependOnClassesThat()
                    .resideInAPackage("..infrastructure..");

    @Test
    public void runArchUnitTests() {
        applicationShouldNotDependOnInfrastructure.check(classes);
    }
}
