# language: es
Característica: login_en_SDA

  @test_TituloValor
  Esquema del escenario: logueo exitoso
    Dado que "Actor" ingresa a la pagina  de SDA
    Cuando ingresa las credenciales correctos
    Y se ingresa al aplicativo Gac
    Y se selecciona tipo de garantía Titulo Valor
    Entonces se genera nueva Garantia Titulo Valor

