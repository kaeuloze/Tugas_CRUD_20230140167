package com.tugas.ktp.controller;

import com.tugas.ktp.dto.KtpDto;
import com.tugas.ktp.service.KtpService;
import com.tugas.ktp.util.WebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
@CrossOrigin(origins = "*")
public class KtpController {

    @Autowired
    private KtpService ktpService;

    // 1. POST /ktp
    @PostMapping
    public ResponseEntity<WebResponse<KtpDto>> createKtp(@RequestBody KtpDto ktpDto) {
        try {
            KtpDto result = ktpService.createKtp(ktpDto);
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("success")
                    .message("Data KTP berhasil ditambahkan!")
                    .data(result)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("error")
                    .message("Gagal tambah data: " + e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    // 2. GET /ktp
    @GetMapping
    public ResponseEntity<WebResponse<List<KtpDto>>> getAllKtp() {
        List<KtpDto> list = ktpService.getAllKtp();
        WebResponse<List<KtpDto>> response = WebResponse.<List<KtpDto>>builder()
                .status("success")
                .message("Berhasil mengambil semua data KTP")
                .data(list)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 3. GET /ktp/{id}
    @GetMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> getKtpById(@PathVariable Integer id) {
        try {
            KtpDto result = ktpService.getKtpById(id);
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("success")
                    .message("Data ditemukan!")
                    .data(result)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("error")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    // 4. PUT /ktp/{id}
    @PutMapping("/{id}")
    public ResponseEntity<WebResponse<KtpDto>> updateKtp(@PathVariable Integer id, @RequestBody KtpDto ktpDto) {
        try {
            KtpDto result = ktpService.updateKtp(id, ktpDto);
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("success")
                    .message("Data KTP berhasil diperbarui!")
                    .data(result)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            WebResponse<KtpDto> response = WebResponse.<KtpDto>builder()
                    .status("error")
                    .message("Gagal update: " + e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 5. DELETE /ktp/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<WebResponse<String>> deleteKtp(@PathVariable Integer id) {
        try {
            ktpService.deleteKtp(id);
            WebResponse<String> response = WebResponse.<String>builder()
                    .status("success")
                    .message("Data KTP dengan ID " + id + " berhasil dihapus")
                    .data(null)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            WebResponse<String> response = WebResponse.<String>builder()
                    .status("error")
                    .message(e.getMessage())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}