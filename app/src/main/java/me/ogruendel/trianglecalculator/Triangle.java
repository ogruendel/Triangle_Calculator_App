package me.ogruendel.trianglecalculator;

/*This class is made by me and was imported from https://github.com/ogruendel/Triangle_Calculator*/

public class Triangle {
    private Double alpha;
    private Double beta;
    private Double gamma;

    private Double a;
    private Double b;
    private Double c;

    public final double toDeg = 180 / Math.PI;
    public final double toRad = Math.PI / 180;

    private boolean isComplete;

    public void calcState() {

        int nonNulls = 0;
        if (alpha != null) nonNulls++;
        if (beta != null) nonNulls++;
        if (gamma != null) nonNulls++;
        if (a != null) nonNulls++;
        if (b != null) nonNulls++;
        if (c != null) nonNulls++;

        if (nonNulls == 3) {
            if (alpha != null && beta != null && gamma != null) {
                throw new IllegalStateException("You cannot calculate a triangle with only 3 angles");
            } else if (a != null && b != null && c != null) {

                /*
                 * For the cases, where there is a given angle and its opposing site, I am using the law of sines (https://en.wikipedia.org/wiki/Law_of_sines)
                 * to calculate one missing angle, then I use the Interior angle sum of a triangle (https://en.wikipedia.org/wiki/Sum_of_angles_of_a_triangle)
                 * to calculate the missing angle, and then I use a rearranged form of the law of sines to calculate the missing site.
                 *
                 * For the cases, where there is not a given angle and its opposing site, I am using the law of cosines (https://en.wikipedia.org/wiki/Law_of_cosines)
                 * to calculate the missing site, and then I use a rearranged form of the law of sines to calculate a missing angle.
                 * After that its just the Interior angle sum of a triangle to get the remaining angle. */

            } else if (alpha != null && a != null && b != null) {
                beta = Math.asin((b * Math.sin(alpha * toRad) / a)) * toDeg;
                gamma = 180 - alpha - beta;
                c = (a * Math.sin(gamma * toRad) / Math.sin(alpha * toRad));

            } else if (alpha != null && a != null && c != null) {
                gamma = Math.asin((c * Math.sin(alpha * toRad) / a)) * toDeg;
                beta = 180 - alpha - gamma;
                b = (a * Math.sin(beta * toRad) / Math.sin(alpha * toRad));

            } else if (alpha != null && b != null && c != null) {
                a = Math.sqrt(b * b + c * c - 2 * b * c * Math.cos(alpha * toRad));
                beta = Math.asin((b * Math.sin(alpha * toRad) / a)) * toDeg;
                gamma = 180 - alpha - beta;

            } else if (beta != null && a != null && b != null) {
                alpha = Math.asin((a * Math.sin(beta * toRad) / b)) * toDeg;
                gamma = 180 - alpha - beta;
                c = (a * Math.sin(gamma * toRad) / Math.sin(alpha * toRad));

            } else if (beta != null && a != null && c != null) {
                b = Math.sqrt(a * a + c * c - 2 * a * c * Math.cos(beta * toRad));
                alpha = Math.asin((a * Math.sin(beta * toRad) / b)) * toDeg;
                gamma = 180 - alpha - beta;

            } else if (beta != null && b != null && c != null) {
                gamma = Math.asin((c * Math.sin(beta * toRad) / b)) * toDeg;
                alpha = 180 - beta - gamma;
                a = (c * Math.sin(alpha * toRad) / Math.sin(gamma * toRad));

            } else if (gamma != null && a != null && b != null) {
                c = Math.sqrt(a * a + b * b - 2 * a * b * Math.cos(gamma * toRad));
                alpha = Math.asin((a * Math.sin(gamma * toRad) / c)) * toDeg;
                beta = 180 - alpha - gamma;

            } else if (gamma != null && a != null && c != null) {
                alpha = Math.asin((a * Math.sin(gamma * toRad) / c)) * toDeg;
                beta = 180 - alpha - gamma;
                b = (c * Math.sin(beta * toRad) / Math.sin(gamma * toRad));

            } else if (gamma != null && b != null && c != null) {
                beta = Math.asin((b * Math.sin(gamma * toRad) / c)) * toDeg;
                alpha = 180 - beta - gamma;
                a = (c * Math.sin(alpha * toRad) / Math.sin(gamma * toRad));

            } else if (alpha != null && beta != null && a != null) {
                gamma = 180 - alpha - beta;
                b = (Math.sin(beta * toRad) * a) / Math.sin(alpha * toRad);
                c = (Math.sin(gamma * toRad) * a) / Math.sin(alpha * toRad);

            } else if (alpha != null && beta != null && b != null) {
                gamma = 180 - alpha - beta;
                a = (Math.sin(alpha * toRad) * b) / Math.sin(beta * toRad);
                c = (Math.sin(gamma * toRad) * b) / Math.sin(beta * toRad);

            } else if (alpha != null && beta != null && c != null) {
                gamma = 180 - alpha - beta;
                a = (Math.sin(alpha * toRad) * c) / Math.sin(gamma * toRad);
                b = (Math.sin(beta * toRad) * c) / Math.sin(gamma * toRad);

            } else if (alpha != null && gamma != null && a != null) {
                beta = 180 - alpha - gamma;
                b = (Math.sin(beta * toRad) * a) / Math.sin(alpha * toRad);
                c = (Math.sin(gamma * toRad) * a) / Math.sin(alpha * toRad);

            } else if (alpha != null && gamma != null && b != null) {
                beta = 180 - alpha - gamma;
                a = (Math.sin(alpha * toRad) * b) / Math.sin(beta * toRad);
                c = (Math.sin(gamma * toRad) * b) / Math.sin(beta * toRad);

            } else if (alpha != null && gamma != null && c != null) {
                beta = 180 - alpha - gamma;
                a = (Math.sin(alpha * toRad) * c) / Math.sin(gamma * toRad);
                b = (Math.sin(beta * toRad) * c) / Math.sin(gamma * toRad);

            } else if (beta != null && gamma != null && a != null) {
                alpha = 180 - beta - gamma;
                b = (Math.sin(beta * toRad) * a) / Math.sin(alpha * toRad);
                c = (Math.sin(gamma * toRad) * a) / Math.sin(alpha * toRad);

            } else if (beta != null && gamma != null && b != null) {
                alpha = 180 - beta - gamma;
                a = (Math.sin(alpha * toRad) * b) / Math.sin(beta * toRad);
                c = (Math.sin(gamma * toRad) * b) / Math.sin(beta * toRad);

            } else if (beta != null && gamma != null && c != null) {
                alpha = 180 - beta - gamma;
                a = (Math.sin(alpha * toRad) * c) / Math.sin(gamma * toRad);
                b = (Math.sin(beta * toRad) * c) / Math.sin(gamma * toRad);

            } else {
                throw new IllegalStateException("This should not have happened");
            }
            isComplete = true;
        }
    }


    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
        calcState();
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
        calcState();
    }

    public double getGamma() {
        return gamma;
    }

    public void setGamma(double gamma) {
        this.gamma = gamma;
        calcState();
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        calcState();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        calcState();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        calcState();
    }

    public boolean isComplete() {
        return isComplete;
    }
}

