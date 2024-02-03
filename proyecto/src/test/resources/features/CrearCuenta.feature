#language:es

Característica: Crear cuenta en opencart

  #Completar las acciones necesarias
  Escenario: Crear una cuenta no registrada en el sitio
    Dado un usuario que se encuentra en la home page
    #Completar el paso con lo necesario para llegar a la pagina de registracion
    Cuando el usuario navega a la pagina de registro
    #Completar el paso con el llenado del formulario
    Y completa la registracion:
      |firstname |Laura                    |
      |lastname  |Rozo                     |
      |email     |laura4@testmail.com |
      |telephone  |351234               |
      |password   |laura123                 |
      |confirm   |laura123                 |

    Entonces el registro fue exitoso

