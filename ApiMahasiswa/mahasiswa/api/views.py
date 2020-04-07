from rest_framework import generics, mixins
from mahasiswa.models import Mahasiswa
from .serializers import MahasiswaSerializer

class MahasiswaView(mixins.CreateModelMixin, generics.ListAPIView):
    lookup_field = 'pk'
    serializer_class = MahasiswaSerializer

    def get_queryset(self):
        return Mahasiswa.objects.all()
    
    def post(self, request, *args, **kwargs):
        return self.create(request, *args, **kwargs)

class MahasiswaRudView(generics.RetrieveUpdateDestroyAPIView):
    lookup_field = 'pk'
    serializer_class = MahasiswaSerializer

    def get_queryset(self):
        return Mahasiswa.objects.all()