#language:es

Característica: Agregar items al carrito en opencart

  #Completar las acciones necesarias
  Escenario: Agregar un item al carrito
    Dado un usuario que realizó login con usuario "prueba9001@prueba.com" y contrasenia "1234"
    Cuando navega a la seccion de camaras
    Y agrega una camara al carrito
    Entonces la camara es visible en el carrito