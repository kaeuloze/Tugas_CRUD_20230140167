## 📝 Deskripsi Proyek
Aplikasi ini merupakan sistem manajemen data KTP berbasis web yang dibangun menggunakan arsitektur Clean Architecture pada Spring Boot. Aplikasi mendukung operasi CRUD (Create, Read, Update, Delete) secara penuh dengan antarmuka pengguna yang interaktif menggunakan AJAX (tanpa refresh halaman).

## 🛠️ Stack Teknologi
- Backend: Java 17, Spring Boot 3.4.x
- Frontend: HTML5, Bootstrap 5, jQuery 3.6 (AJAX)
- Database: MySQL 8.x
- Build Tool: Maven

## 📂 Struktur Package
* model: Kelas Entity untuk representasi tabel database.
* dto: Data Transfer Object untuk pertukaran data API.
* repository: Interface Spring Data JPA untuk akses database.
* service: Interface untuk logika bisnis.
* service.impl: Implementasi dari Service Layer.
* controller: REST API Endpoint.
* mapper: Komponen untuk konversi Entity ke DTO dan sebaliknya.
* util: Kelas bantuan (seperti Wrapper Response standar).

## ⚙️ Cara Menjalankan Program
1. **Konfigurasi Database:**
   Buat database bernama `spring` di MySQL dan sesuaikan `application.properties`:
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring
   spring.datasource.username=root
   spring.datasource.password=your_password

```

2. Jalankan Aplikasi:
Jalankan file TugasCrudNimApplication.java dari IDE Anda (IntelliJ/VS Code).
3. Akses Website:
Buka browser dan arahkan ke: http://localhost:8080

---

### 📡** Dokumentasi API & Hasil Pengujian**

Semua request menggunakan format JSON dan mengembalikan response standar melalui `WebResponse<T>`.
| Method | Endpoint | Fungsi |
| --- | --- | --- |
| POST | /ktp | Menambah data KTP baru |
| GET | /ktp | Mengambil seluruh daftar KTP |
| GET | /ktp/{id} | Mengambil detail KTP berdasarkan ID |
| PUT | /ktp/{id} | Memperbarui data KTP berdasarkan ID |
| DELETE | /ktp/{id} | Menghapus data KTP dari database |


#### 1. Tambah Data KTP (`POST /ktp`)

**Request Body:**

```json
{
    "alamat": "Tegal",
    "jenisKelamin": "Laki-laki",
    "namaLengkap": "Dipo Sanjaya",
    "nomorKtp": "12345676543123",
    "tanggalLahir": "2020-06-10"
}

```

**Response Body:**

```json
{
    "message": "Data KTP berhasil ditambahkan!",
    "status": "success",
    "data": {
        "alamat": "Tegal",
        "id": 2,
        "jenisKelamin": "Laki-laki",
        "namaLengkap": "Dipo Sanjaya",
        "nomorKtp": "12345676543123",
        "tanggalLahir": "2020-06-10"
    }
}

```

#### 2. Ambil Semua Data (`GET /ktp`)

**Response Body:**

```json
{
    "message": "Berhasil mengambil semua data KTP",
    "status": "success",
    "data": [
        {
            "id": 1,
            "nomorKtp": "1571070101050202",
            "namaLengkap": "Choirul Amir Siregar",
            "alamat": "Jl. Untung Suropati Kel.Aur Kenali Kec.Telanaipura Kota Jambi",
            "tanggalLahir": "2005-01-01",
            "jenisKelamin": "Laki-laki"
        },
        {
            "id": 2,
            "nomorKtp": "12345676543123",
            "namaLengkap": "Dipo Sanjaya",
            "alamat": "Tegal",
            "tanggalLahir": "2020-06-10",
            "jenisKelamin": "Laki-laki"
        }
    ]
}

```

#### 3. Update Data KTP (`PUT /ktp/{id}`)

**Request Body:**

```json
{
    "alamat": "Tegal",
    "jenisKelamin": "Laki-laki",
    "namaLengkap": "Dipo Sanjaya Purnomo",
    "nomorKtp": "12345676543123",
    "tanggalLahir": "2020-06-10"
}

```

**Response Body:**

```json
{
    "message": "Data KTP berhasil diperbarui!",
    "status": "success",
    "data": {
        "id": 2,
        "nomorKtp": "12345676543123",
        "namaLengkap": "Dipo Sanjaya Purnomo",
        "alamat": "Tegal",
        "tanggalLahir": "2020-06-10",
        "jenisKelamin": "Laki-laki"
    }
}

```

#### 4. Hapus Data KTP (`DELETE /ktp/{id}`)

**Response Body:**

```json
{
    "message": "Data KTP dengan ID 1 berhasil dihapus",
    "status": "success",
    "data": null
}

```


1. Tampilan Utama (Daftar KTP)
<img width="1919" height="964" alt="Screenshot 2026-03-13 165427" src="https://github.com/user-attachments/assets/e1fbeda4-0789-4700-b6c6-1adeb05a2aff" />


2. Form Tambah, Edit, Hapus & Validasi Error
<img width="1919" height="904" alt="Screenshot 2026-03-13 165542" src="https://github.com/user-attachments/assets/a5157c24-3394-41ec-9838-6a3fdb6951e6" />

<img width="1918" height="958" alt="Screenshot 2026-03-13 165203" src="https://github.com/user-attachments/assets/8b3d0e4a-6ad4-44cb-a8d6-760b8a870503" />

<img width="1919" height="958" alt="Screenshot 2026-03-13 164256" src="https://github.com/user-attachments/assets/95d4bdc2-05ee-43d8-9a34-ce83fbba9c68" />


Validasi Error
<img width="1919" height="951" alt="Screenshot 2026-03-13 164425" src="https://github.com/user-attachments/assets/ee4512e8-384d-433c-878b-d9c9fcfcacbc" />


3. Notifikasi Berhasil (Feedback)
<img width="1917" height="958" alt="Screenshot 2026-03-13 164129" src="https://github.com/user-attachments/assets/811b99b0-9bec-4571-a6df-e9a43b26dfa4" />

<img width="1919" height="964" alt="Screenshot 2026-03-13 164225" src="https://github.com/user-attachments/assets/553d0e60-eb64-4a5e-94ab-0e1de9e332fa" />

<img width="1919" height="958" alt="Screenshot 2026-03-13 164256" src="https://github.com/user-attachments/assets/b5224090-4693-4900-8169-32e9c4632585" />


Database MySql
<img width="1919" height="752" alt="image" src="https://github.com/user-attachments/assets/dcfc09ae-ab32-412f-b204-d4ae8c9fae93" />


# Tugas Praktikum: CRUD Manajemen KTP
Nama: Mariska Esa Purnomo  
NIM: 20230140167 
Repositori: Tugas_CRUD_20230140167
