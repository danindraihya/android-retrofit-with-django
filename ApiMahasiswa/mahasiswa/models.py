from django.db import models

class Mahasiswa(models.Model):
    nama = models.CharField(max_length=255)
    alamat = models.TextField()

    def __str__(self):
        return self.nama
