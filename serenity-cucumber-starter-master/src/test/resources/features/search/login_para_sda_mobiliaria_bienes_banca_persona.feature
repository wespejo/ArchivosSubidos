# language: es

Característica: login_en_SDA

  @testmobiliariabp
  Esquema del escenario: logueo exitoso
    Dado que "Actor" ingresa a la pagina  de SDA
    Cuando ingresa las credenciales correctos
    Y se ingresa al aplicativo Gac
    Y se selecciona tipo de Garantia Mobiliaria Bienes Banca Persona
    Entonces se genera nueva Garantia Mobiliaria Bienes Banca Persona