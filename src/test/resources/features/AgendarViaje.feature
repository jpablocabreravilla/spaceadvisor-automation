@tag
Feature: Agendar viaje con filtro de precios
  Como PO quiero agendar un viaje en línea con el filtro de precios
  para entregar independencia a mis clientes.

  Background:
    Given el usuario ingresa a la web de reservas

  Scenario Outline: Reserva exitosa filtrando por precio
    When selecciona fechas de partida "<partida>" y regreso "<regreso>"
    And define pasajeros adultos "<adultos>" y ninos "<ninos>"
    And pulsa el boton Select Destination y luego el boton Load More
    And filtra por precio minimo "<min>" y maximo "<max>"
    And elige el destino "<destino>"
    And completa el formulario con nombre "<nombre>", email "<email>", ssn "<ssn>", telefono "<telefono>"
  #  And adjunta archivo al formulario "<archivo>"
    And aplica el cupon "<cupon>"
    And acepta los terminos y condiciones y pagar
    #Then deberia ver el mensaje "Destination Booked"
    Then Pause

    Examples:
      | partida    | regreso    | adultos | ninos | min | max  | destino               | nombre       | email         | ssn         | telefono     | archivo                        | cupon   |
      | 25/09/2025 | 01/10/2025 | 2       | 1     | 100 | 1799 | Sant Cugat Del Valles | Juan Cabrera | juan@test.com | 123-45-6789 | +17871234567 | src/test/resources/data/id.png | PROMO10 |