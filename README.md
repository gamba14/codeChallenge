# Mutants code challenge.

## Consigna

Te ha contratado a ti para que desarrolles un proyecto que detecte si
un humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa JAVA con un método o función con la siguiente
firma:

```
boolean isMutant(String[] dna);
```

En donde recibirás como parámetro un array de Strings que representan cada fila de una
tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G)
las cuales representa cada base nitrogenada del ADN.

## Ejecución
La aplicación se ejecutará en torno a las pruebas unitarias usando el wrapper de Maven y el goal de test.

Desde Linux
```bash
./mvnw test
```

Desde Windows
```cmd
mvnw test
```