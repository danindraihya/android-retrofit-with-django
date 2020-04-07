from django.urls import path
from .views import MahasiswaRudView, MahasiswaView

urlpatterns = [
    path('mahasiswa/<int:pk>', MahasiswaRudView.as_view(), name='mahasiswa-rud'),
    path('mahasiswa', MahasiswaView.as_view(), name='mahasiswa')
]