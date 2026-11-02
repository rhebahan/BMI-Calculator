# BMI-Calculator
Aplikasi desktop sederhana untuk menghitung Body Mass Index (BMI) dari berat dan tinggi badan. Dibuat dengan JavaFX, FXML, dan Maven, menggunakan pola MVC (Model, View, Controller).

## Fitur
- Pilihan jenis kelamin (Cowok / Cewek)
- Input berat (kg) dan tinggi (cm)
- Hasil BMI beserta kategorinya (kurus, normal, kelebihan berat badan, obesitas)
- Skala warna dengan penanda yang menunjukkan posisi BMI
- Saran singkat sesuai kategori
- Validasi input: kolom kosong, bukan angka, dan angka di luar batas wajar akan menampilkan pesan error

## Rumus dan Kategori
` BMI = berat (kg) / tinggi (m) * tinggi (m)

| BMI | Kategori |
| --- | --- |
| kurang dari 18,5 | Kekurangan Berat Badan |
| 18,5 sampai kurang dari 25 | Ideal / Normal |
| 25 sampai kurang dari 30 | Kelebihan Berat Badan |
| 30 atau lebih | Obesitas |

Batas input yang diterima: tinggi 50-250 cm, berat 10-400 kg.

