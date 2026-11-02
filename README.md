# BMI-Calculator
Aplikasi desktop sederhana untuk menghitung Body Mass Index (BMI) dari berat dan tinggi badan. Dibuat dengan JavaFX, FXML, dan Maven, menggunakan pola MVC (Model, View, Controller).

## Fitur
- Pilihan jenis kelamin (Cowok / Cewek

)
- Input berat (kg) dan tinggi (cm)
- Hasil BMI beserta kategorinya (kurus, normal, kelebihan berat badan, obesitas)
- Skala warna dengan penanda yang menunjukkan posisi BMI
- Saran singkat sesuai kategori
- Validasi input: kolom kosong, bukan angka, dan angka di luar batas wajar akan menampilkan pesan error

## Rumus dan Kategori
``` BMI = berat (kg) / tinggi (m) * tinggi (m) ```

| BMI | Kategori |
| --- | --- |
| kurang dari 18,5 | Kekurangan Berat Badan |
| 18,5 sampai kurang dari 25 | Ideal / Normal |
| 25 sampai kurang dari 30 | Kelebihan Berat Badan |
| 30 atau lebih | Obesitas |

Batas input yang diterima: tinggi 50-250 cm, berat 10-400 kg.

## Tampilan Applikasi
<img width="878" height="550" alt="Screenshot 2026-11-02 075641" src="https://github.com/user-attachments/assets/54d0344e-7cb3-47df-9d98-e84bc2e86409" />

<img width="876" height="550" alt="Screenshot 2026-11-02 075816" src="https://github.com/user-attachments/assets/792adef5-80a5-4934-8e38-0ad5c6fe638e" />

## Cara Menjalankan
### Lewat Terminal
```bash
git clone https://github.com/rhebahan/BMI-Calculator.git
cd Calculator_BMI
mvn clean javafx:run
```

### Lewat NetBeans
1. Pilih File > Open Project, lalu buka folder Calculator_BMI.
2. Klik kanan project, pilih Properties > Actions > Run project.
3. Isi Execute Goals dengan clean javafx:run, dan kosongkan Set Properties.
4. Klik OK, lalu klik kanan project dan pilih Run.
