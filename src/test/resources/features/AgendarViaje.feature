@AgendarViaje
Feature: Agendar viaje parametrizando los filtros.
  Como PO quiero agendar un viaje en línea haciendo uso de los filtros
  para entregar independencia a mis clientes.

  Background:
    Given el usuario ingresa a la web de reservas

  @FiltroA
  Scenario Outline: Reserva exitosa filtrando por precio
    When selecciona fechas de partida "<partida>" y regreso "<regreso>"
    And define pasajeros adultos "<adultos>" y ninos "<ninos>"
    And pulsa el boton Select Destination y luego el boton Load More
    And filtra por precio minimo "<min>" y maximo "<max>"
    And filtra por el destino "<destino>"
    And selecciona la tarjeta filtrada
    And completa el formulario con nombre "<nombre>", email "<email>", ssn "<ssn>", telefono "<telefono>"
    And adjunta archivo al formulario "<archivo>"
    And aplica el cupon "<cupon>"
    And acepta los terminos y condiciones
    And finalizar el pago
    Then deberia ver el mensaje "Destination Booked"

    Examples:
      | partida    | regreso    | adultos | ninos | min | max  | destino               | nombre       | email         | ssn         | telefono     | archivo                              | cupon   |
      | 25/09/2025 | 01/10/2025 | 2       | 1     | 100 | 1000 | Tongli | Juan Cabrera | juan@test.com | 123-45-6789 | +17871234567 | src/test/resources/data/dataTest.png | PROMO10 |

      # Reglas y restricciones para este escenario:
      # 1. Las fechas de partida y regreso deben seguir el formato dd/mm/yyyy.
      # 2. La cantidad de adultos debe estar entre 1 y 4.
      # 3. La cantidad de niños debe estar entre 1 y 4.
      # 4. El filtro de precios debe aceptar un rango numérico mínimo y máximo.
      # 5. El destino debe venir parametrizado desde el Example.
      # 6. El nombre y el email deben ser valores válidos (email con formato estándar).
      # 7. El número de seguro social (SSN) debe seguir el patrón ###-##-####.
      # 8. El número de teléfono debe iniciar con +1787 y contener exactamente 7 dígitos adicionales.
      # 9. La ruta del archivo debe existir dentro de src/test/resources/data/.
      # 10. El código de cupón debe venir parametrizado desde el Example.
      # 11. Al presionar el botón PAY NOW, el sistema debe mostrar/simular el mensaje "Destination Booked".
      #     -> Fallo intencionado ya que la web no muestra dicho mensaje.

  @FiltroB
  Scenario Outline: Reserva exitosa filtrando por color de planeta
    When selecciona fechas de partida "<partida>" y regreso "<regreso>"
    And define pasajeros adultos "<adultos>" y ninos "<ninos>"
    And pulsa el boton Select Destination y luego el boton Load More
    And elige el color del planeta  "<color>"
    And filtra por el destino "<destino>"
    And selecciona la tarjeta filtrada
    And completa el formulario con nombre "<nombre>", email "<email>", ssn "<ssn>", telefono "<telefono>"
    And adjunta archivo al formulario "<archivo>"
    And aplica el cupon "<cupon>"
    And finalizar el pago

    Examples:
      | partida    | regreso    | adultos | ninos | color | destino | nombre       | email         | ssn         | telefono     | archivo                              | cupon   |
      | 25/09/2025 | 01/10/2025 | 2       | 1     | Red   | Shenji  | Juan Cabrera | juan@test.com | 123-45-6789 | +17871234567 | src/test/resources/data/dataTest.png | PROMO10 |

      # Reglas y restricciones para este escenario:
      # 1. Las fechas de partida y regreso deben seguir el formato dd/mm/yyyy.
      # 2. La fecha de regreso debe ser posterior a la fecha de partida.
      # 3. La cantidad de adultos debe estar entre 1 y 4.
      # 4. La cantidad de niños debe estar entre 1 y 4.
      # 5. El color del planeta debe venir parametrizado desde el Example y coincidir con una opción válida.
      # 6. El destino debe venir parametrizado desde el Example y encontrarse dentro de los resultados filtrados.
      # 7. El nombre y el email deben ser valores válidos (email con formato estándar).
      # 8. El número de seguro social (SSN) debe seguir el patrón ###-##-####.
      # 9. El número de teléfono debe iniciar con +1787 y contener exactamente 7 dígitos adicionales.
      # 10. La ruta del archivo debe existir dentro de src/test/resources/data/.
      # 11. El código de cupón debe venir parametrizado desde el Example.
      # 12. Al presionar el botón PAY NOW, la transacción debe completarse (sin necesidad de aceptar términos en este escenario).