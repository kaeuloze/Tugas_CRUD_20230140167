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



2. Form Tambah & Validasi Error


3. Notifikasi Berhasil (Feedback)


