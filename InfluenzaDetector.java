/**
 * UPB, ACS, POO CB 2022-2023
 * @author Gabriel Gutu-Robu
 *
 */

public class InfluenzaDetector {

    Mucus mucus;
    static float influenzaAThreshold = 0.6f;
    static float influenzaBThreshold = 0.4f;
    static float covidThreshold = 0.7f;

    void checkAllFlyTypes(Mucus mucus) {
        this.mucus = mucus;

        class InfluenzaA {
            private final Mucus mucus;

            public InfluenzaA(Mucus mucus) {
            this.mucus = mucus;
        }
            public String getFluName() {
                return mucus.type.name().equals("INFLUENZA_A") ? "INFLUENZA_A" : "NOT INFLUENZA_A";
            }

            public boolean isInfected() {
                return mucus.type.name().equals("INFLUENZA_A") && mucus.percentage > influenzaAThreshold;
            }
        }

        class InfluenzaB {
            private final Mucus mucus;

            public InfluenzaB(Mucus mucus) {
            this.mucus = mucus;
            }

            public String getFluName() {
                return mucus.type.name().equals("INFLUENZA_B") ? "INFLUENZA_B" : "NOT INFLUENZA_B";
            }

            public boolean isInfected() {
                return mucus.type.name().equals("INFLUENZA_B") && mucus.percentage > influenzaBThreshold;
            }
        }

        class COVID {
            private Mucus mucus;

            public COVID(Mucus mucus) {
                this.mucus = mucus;
            }

            public String getFluName() {
                return mucus.type.name().equals("COVID") ? "COVID" : "NOT COVID";
            }

            public boolean isInfected() {
                return mucus.type.name().equals("COVID") && mucus.percentage > covidThreshold;
            }
        }

        InfluenzaA fluA = new InfluenzaA(mucus);
        System.out.println(fluA.getFluName() + " result: Mucus is " + (fluA.isInfected() ? "Positive" : "either Negative or Unknown"));

        InfluenzaB fluB = new InfluenzaB(mucus);
        System.out.println(fluB.getFluName() + " result: Mucus is " + (fluB.isInfected() ? "Positive" : "either Negative or Unknown"));

        COVID covid = new COVID(mucus);
        System.out.println(covid.getFluName() + " result: Mucus is " + (covid.isInfected() ? "Positive" : "either Negative or Unknown"));

    }

}
