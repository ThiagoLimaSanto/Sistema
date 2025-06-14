from django.db import models

class Usuario(models.Model):
    id = models.AutoField(primary_key=True)
    usuario = models.CharField(max_length=100)
    senha = models.CharField(max_length=100)
    categoria = models.CharField(max_length=10)

    def __str__(self):
        return self.usuario