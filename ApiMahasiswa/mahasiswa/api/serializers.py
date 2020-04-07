from rest_framework import serializers
from mahasiswa.models import Mahasiswa

class MahasiswaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Mahasiswa
        fields = [
            'pk',
            'nama',
            'alamat'
        ]