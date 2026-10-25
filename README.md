# PAM Modul 7 — Implicit Intents

Project Android Java/XML berisi dua aplikasi:
- `app`: membuka website, membuka lokasi di peta, dan berbagi teks.
- `receiver`: menerima URL `http://developer.android.com` melalui implicit intent.

## Build online tanpa Android Studio
1. Upload seluruh isi folder project ini ke repository GitHub.
2. Buka tab **Actions** dan aktifkan workflow bila diminta.
3. Jalankan workflow **Build Android APKs** melalui **Run workflow**.
4. Setelah selesai, buka hasil run workflow dan unduh artifact `pam-modul7-apks`.
5. Artifact berisi `app-debug.apk` dan `receiver-debug.apk`.

Workflow menggunakan Gradle di runner GitHub, sehingga tidak perlu menginstal Android Studio di laptop.

## Uji fitur
- Pasang kedua APK ke satu emulator cloud yang mendukung instalasi beberapa APK.
- Buka `Implicit Intents`, uji Open Website, Open Location, dan Share This Text.
- Untuk menguji receiver, tekan Open Website dengan URL default `http://developer.android.com` lalu pilih `Implicit Intents Receiver` dari chooser.
- Receiver sengaja hanya menerima host dan skema tersebut, mengikuti modul praktikum.

Catatan: layanan emulator cloud bisa membatasi pemasangan beberapa APK atau fitur aplikasi eksternal. Jika demikian, screenshot tiga tombol utama tetap dapat diambil, tetapi pengujian receiver membutuhkan emulator yang mendukung dua APK.
