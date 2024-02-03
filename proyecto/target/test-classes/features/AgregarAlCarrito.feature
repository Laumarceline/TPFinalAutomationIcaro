#language:es

Característica: Agregar items al carrito en opencart

  #Completar las acciones necesarias
  Escenario: Agregar un item al carrito
    Dado un usuario que realizó login con usuario "laura2@testmail.com" y contrasenia "laura123"
    Cuando navega a la seccion de camaras
    Y agrega una camara al carrito
    Entonces la camara es visible en el carrito