# Poyectos de POO

Este repositorio tiene como propósito realizar las tareas de la materia "Programación Orientada a Objetos" (POO) pero con uno que otro patrón de programación funcional (FP).

Cada directorio se destina a un proyecto, compuesto del código fuente (carpeta _src_) y una pequeña documentación (archivo _README.md_) con las instrucciones del profesor e instrucciones de cómo compilar y ejecutar el proyecto desde línea de comandos. Igual es posible copiar la carpeta _src_ en tu IDE de preferencia (_NetBeans_, _IntelliJ IDEA_ o _Eclipse_) y ejecutar los proyectos desde ahí. Yo codifico y ejecuto los proyectos en IntelliJ IDEA.

## Conceptos relacionados a un estilo funcional

Así como la programación orientada a objetos tiene los principios SOLID, la programación funcional tiene sus formas para lograr el desarrollo de código mantenible, robusto, legible, bonito, etc.

Los conceptos de POO deben ser abarcados por el profesor, así que no serán explicados en este documento.

### Transparencia

Esto quiere decir que una función debe recibir todos sus datos de entrada mediante parámetros. En otras palabras, se evita el uso de `this`. En realidlad esto no es ninguna limitante, pues cualquier método puede ser visto como una función que además de recibir datos de forma explícita, mediante argumentos, recibe datos de forma implícita debido al `this`. A mí me funciona ser explícito al describir mis ideas.

Quizá te preguntes _¿cómo puedo llamar a otros métodos sin el uso de `this`?_, y la respuesta es que puedes pasar el método como parámetro. En programación funcional, las funciones también son datos. Las funciones que reciben o devuelven otras funciones se conocen como [funciones de orden superior](https://eloquentjavascript.net/05_higher_order.html). Java facilita este patrón con el [operador `::`](https://www.geeksforgeeks.org/double-colon-operator-in-java/) y las [interfaces funcionales](https://www.educative.io/edpresso/a-list-of-all-the-functional-interfaces-in-java).

Para algunos la sintaxis tiene mucha importancia. Al inicio ser explícito es verboso, pero técnicas como la [aplicación parcial](https://github.com/getify/Functional-Light-JS/blob/master/manuscript/ch3.md/#some-now-some-later), el [_point-free style_](https://github.com/getify/Functional-Light-JS/blob/master/manuscript/ch3.md/#no-points) y la [composición de funciones](https://youtu.be/srQt1NAHYC0?t=563) ayudan a mitigar esto. Hay lenguajes como Elixir o Elm [cuya sintaxis facilita estas técnicas](https://dennisreimann.de/articles/elm-functions.html).

**Nota técnica:** Para que la aplicación parcial sea posible es necesario que el lenguaje de programación en cuestión pueda hacer [_closures_](https://github.com/getify/You-Dont-Know-JS/tree/1st-ed/scope%20%26%20closures) o algo similar.

### Inmutabilidad

> El comando _GOTO_ era malvado porque hacía que nos preguntemos "¿cómo llegué a este punto en la ejecución?".
> La mutabilidad hace que nos preguntemos "¿cómo llegué a este estado?".
>
> — [Jessica Joy Kerr](https://twitter.com/jessitron/status/333228687208112128)

### Evitar efectos secundarios

Estas son funciones que no tienen efectos secundarios. Un efecto secundario puede ser imprimir datos en la consola (por ejemplo, con `System.out.println`), acceder a una variable global, usar `this`, leer o modificar una base de datos, etc.

Obsérvese que las funciones puras también son transparentes, deterministas y no mutan datos.

Recomiendo ver la plática [Functional architecture - The pits of success — Mark Seemann](https://youtu.be/US8QG9I1XW0), pues explica los beneficios de usar funciones puras en proyectos grandes.

### Determinismo

En las funciones matemáticas, dados los mismos datos de entrada siempre se tiene el mismo resultado. Una función determinista es aquella que siempre retorna el mismo valor dados los mismos argumentos. Si construimos nuestras funciones de esa forma, el comportamiento es más predecible y hay que estar pendiente de menos cosas a la vez, haciendo nuestro código más fácil de mantener. En teoría (no digo que sea una buena práctica) se podría reemplazar la invocación de una función determinista con el resultado de la misma y el programa funcionaría igual.

```java
double[] numeros = new double[] { 1, 2, 3, 4, 5 };

double promedio = 15;
double minimo = 1;
double maximo = 5;
```

### La programación funcional es declarativa

En lugar de escribir el algoritmo para llegar a un resultado, en un programa declarativo se escribe qué resultado se desea.

Por ejemplo: se tiene un arreglo **_arrayA_** de objetos y se desean usar todos aquellos que no sean nulos. Una solución es crear un nuevo arreglo **_arrayB_** con todos los valores no-nulos de **_arrayA_**. En la forma imperativa (describiendo los pasos del algoritmo) tendríamos que crear una lista, guardar los elementos no-nulos en esa lista y luego convertirla a un arreglo.

```java
Integer[] arrayA = new Integer[] { 1, 2, null, 3, null, 4, 5 };

List<Integer> listB = new ArrayList<>();
for (Integer obj : arrayA) {
    if (Objects.nonNull(obj)) {
        listB.add(obj);
    }
}

Integer[] arrayB = listB.toArray(new Integer[listB.size()]);

// Hacer algo con B
// ...
```

En un código declarativo, llamamos a una función que filtre todos los objetos de acuerdo a cierto criterio. En java podemos usar [Stream.filter](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html).

```java
Integer[] arrayA = new Integer[] { 1, 2, null, 3, null, 4, 5 };


Integer[] arrayB = Arrays.stream(arrayA)
            .filter(Objects::nonNull)
            .toArray(Integer[]::new);

// Hacer algo con B
// ...
```

### Operadores de listas

¿Qué tal si en lugar de escribir ciclos solo escribes qué resultado esperas? Ya vimos el operador de `filter` como un sustituto del ciclo `for` en cierto escenario. Sin embargo, este no es el único operador de tal índole. Por ejemplo, la función [`List.map` en _Elm_](https://package.elm-lang.org/packages/elm/core/latest/List#map) recibe una función que trabaja en elementos y la convierte en una función que trabaja en listas:

```elm
sumarDos número = número + 2

sumarDos 4
-- Resultado: 6

sumarDosLista = List.map sumarDos

sumarDosLista [1, 2, 3, 4, 5]
-- Resultado: [3, 4, 5, 6, 7]
```

Estas funciones, conocidas como operadores de listas, tienen como objetivo abstraer el código encargado de hacer ciclos. Para más información sobre las ventajas de los operadores de lista, ver [A Skeptics Guide To Functional STYLE JavaScript — Jonathan Mills](https://youtu.be/oF9XTJoScOE?t=430).

Existen otros operadores como `reduce`, `flatMap`, `flatten`, `zip`, etc.
