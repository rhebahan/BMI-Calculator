package model;

public class BMI {
    private final double tinggiCm;
    private final double beratKg;
    private final Gender gender;

    public BMI(double tinggiCm, double beratKg, Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Pilih jenis kelamin dulu.");
        }
        if (!(tinggiCm >= 50 && tinggiCm <= 250)) {
            throw new IllegalArgumentException("Tinggi badan harus antara 50 - 250 cm.");
        }
        if (!(beratKg >= 10 && beratKg <= 400)) {
            throw new IllegalArgumentException("Berat badan harus antara 10 - 400 kg.");
        }
        this.tinggiCm = tinggiCm;
        this.beratKg = beratKg;
        this.gender = gender;
    }

    private double tinggiM() {
        return tinggiCm / 100.0;
    }

    public double hitungSkor() {
        return beratKg / (tinggiM() * tinggiM());
    }

    public String getKategori() {
        double skor = hitungSkor();
        if (skor < 18.5) {
            return "Kekurangan Berat Badan";
        } else if (skor < 25.0) {
            return "Ideal / Normal";
        } else if (skor < 30.0) {
            return "Kelebihan Berat Badan";
        } else {
            return "Obesitas";
        }
    }

    public String getWarna() {
        double skor = hitungSkor();
        if (skor < 18.5) {
            return "#3B82F6";
        } else if (skor < 25.0) {
            return "#10B981";
        } else if (skor < 30.0) {
            return "#F59E0B";
        } else {
            return "#EF4444";
        }
    }

    public String getSaran() {
        double skor = hitungSkor();
        if (skor < 18.5) {
            return "Berat badanmu di bawah rentang sehat. Coba perbaiki pola makan dan cukupi asupan nutrisimu.";
        } else if (skor < 25.0) {
            return "NICEEEE! Berat badanmu ada di rentang sehat. Pertahankan pola makan dan olahraga yaa.";
        } else if (skor < 30.0) {
            return "Berat badanmu sedikit di atas rentang sehat. Mulai atur porsi makan dan rutin bergerak.";
        } else {
            return "Berat badanmu jauh di atas rentang sehat. Sebaiknya segera konsultasi ke dokter atau ahli gizi.";
        }
    }

    public double getBeratSehatMin() {
        return 18.5 * tinggiM() * tinggiM();
    }

    public double getBeratSehatMax() {
        return 24.9 * tinggiM() * tinggiM();
    }

    public double getBeratIdeal() {
        double inciDiAtas5Kaki = Math.max(0, tinggiCm / 2.54 - 60);
        double dasar = (gender == Gender.COWOK) ? 50.0 : 45.5;
        return dasar + 2.3 * inciDiAtas5Kaki;
    }

    public Gender getGender() {
        return gender;
    }
}
