# Poyectos de POO
Este repositorio tiene como propósito realizar las tareas de la materia "Programación Orientada a Objetos" (POO) con el profesor Edwin aplicando cosas del paradigma orientado a objetos pero con uno que otro patrón de programación funcional (FP) para mejorar la legibilidad.

Es open-source para que los alumnos de la Facultad de Matemáticas UADY puedan _Comparar resultados_.

Cada directorio se destina a un proyecto, compuesto del código fuente (carpeta _src_) y una pequeña documentación (archivo _README.md_) con las instrucciones del profesor e instrucciones de cómo compilar y ejecutar el proyecto desde línea de comandos. Igual es posible copiar la carpeta _src_ en tu IDE de preferencia (_NetBeans_, _IntelliJ IDEA_ o _Eclipse_) y dejar que este lo haga. Yo codifico y ejecuto los proyectos en IntelliJ IDEA.

## Conceptos relacionados a un estilo funcional
A pesar de que no voy a aplicar muchos patrones funcionales, sí me gustaría explicarlos para que nadie tenga dudas al leer las tres líneas de código donde aparezcan. No es obligatorio leer todo este documento, igual pueden ver [este video](https://youtu.be/FYXpOjwYzcs) que explica los mismos conceptos (y unos cuantos más) pero en JavaScript. Otras opciones son ignorar estos conceptos y seguir usando POO, o copiar a lo desgraciado sin leer nada.

El profesor va a decir cosas de POO, así que este documento no abarcará los conceptos de tal paradigma. Lo único que voy a agregar es que los métodos no estáticos solo son funciones que, además de recibir datos explícitamente mediante parámetros, recibe datos implícitamente mediante el `this` y normalmente generan efectos secundarios.

Así como POO tiene los principios SOLID para hacer buenos programas, la FP también tiene uno que otro. En estos proyectos no se seguirán al 100% porque el propósito de la materia es aprender POO y estos principios no se apegan bien a dicho paradigma. Aún así vale la pena explorarlos.

### Transparencia
Esto quiere decir que una función debe recibir todos sus datos de forma explícita (mediante parámetros). En Java, si una función puede ser estática y no depende de otras variables estáticas, entonces es transparente.

### Inmutabilidad
Si le paso un valor por referencia a una función (ya sea un arreglo, objeto o alguna otra estructura de datos), tal valor no se verá afectado. Veamos el siguiente bloque de código:

```java
double[] numeros = new double[] { 1, 2, 3, 4, 5 };

double promedio = calcularPromedio(numeros);
double minimo = calcularMinimio(numeros);
double maximo = calcularMaximo(numeros);
```

Uno esperaría que el promedio sea 3, el mínimo 1 y el máximo 5. Pero, ¿qué pasaría si en la implementación de algún método se muta el arreglo?

```java
public double calcularPromedio(double[] numeros) {
    // Guardar la suma en el primer valor para "optimizar"
    for (int i = 1; i < numeros.length; i++) {
        numeros[0] = numeros[i] + numeros[0];
    }
    
    return numeros[0] / numeros.length;
}
```

En este caso, el valor de `promedio` sería 3, pero el de `minimo` sería 2 y el `maximo` sería 15. Si solo leemos el bloque principal, no sería claro por qué obtenemos estos resultados inesperados. Pero si hubiéramos implementado `calcularPromedio` de forma que no mute el arreglo de números, no tendríamos este problema.

### Determinismo
En las funciones matemáticas, dados los mismos datos de entrada siempre se tiene el mismo resultado. Una función determinista es aquella que siempre retorna el mismo valor dados los mismos argumentos. Si construimos nuestras funciones de esa forma, el comportamiento es más predecible y hay que estar pendiente de menos cosas a la vez, haciendo nuestro código más fácil de mantener. En teoría (no digo que sea una buena práctica) se podría reemplazar la invocación de una función determinista con el resultado de la misma y el programa funcionaría igual.
```java
double[] numeros = new double[] { 1, 2, 3, 4, 5 };

double promedio = 15;
double minimo = 1;
double maximo = 5;
```

### Funciones puras
Estas son funciones que no tienen efectos secundarios. Un efecto secundario puede ser imprimir datos en la consola (por ejemplo, con `System.out.println`), acceder a una variable global, usar `this`, leer o modificar una base de datos, etc.

Obsérvese que las funciones puras también son transparentes, deterministas y no mutan datos.

Recomiendo ver [esta plática](https://youtu.be/US8QG9I1XW0) que explica los beneficios de las funciones puras en proyectos grandes. Es algo larga, puedes preparar palomitas antes de verla.

### Funciones de orden superior
Son funciones que reciben o devuelven otras funciones. Pasar bloques de código de un lado a otro nos brinda una flexibilidad increíble y permite reciclar bloques de código fácilmente.

### La programación funcional es declarativa
Este es el aspecto de la programación funcional que más me llamó la atención, y le tengo algo de cariño porque una vez lo entendí me empezó a gustar el paradigma. En lugar de escribir el algoritmo para llegar a un resultado, en un programa declarativo se escribe qué resultado se desea. Recomiendo mucho el [primer capítulo de _Functional-Light-JS_](https://github.com/getify/Functional-Light-JS/blob/master/manuscript/ch1.md/#chapter-1-why-functional-programming), pues es el texto que me mostró por qué ese concepto es poderoso. Además, siento que mi ejemplo no le hace justicia.

Imagina que se tiene un arreglo _A_ de objetos y se desean usar todos aquellos que no sean nulos. Una solución es crear un nuevo arreglo _B_ con todos los valores no-nulos de _A_. En la forma imperativa (describiendo los pasos del algoritmo) tendríamos que crear una lista, guardar los elementos no-nulos en esa lista y luego convertirla a un arreglo.

```java
Integer[] A = new Integer[] { 1, 2, null, 3, null, 4, 5 };

List<Integer> listB = new ArrayList<>();
for (Integer obj : A) {
    if (Objects.nonNull(obj)) {
        listB.add(obj);
    }
}

Integer[] B = listB.toArray(new Integer[listB.size()]);

// Hacer algo con B
// ...
```

En un código declarativo, llamamos a una función que filtre todos los objetos de acuerdo a cierto criterio. En este caso, el criterio es que el valor no sea nulo.

```java
Integer[] A = new Integer[] { 1, 2, null, 3, null, 4, 5 };

// Guardar todos los objetos no-nulos del arreglo A en un nuevo arreglo de tipo Integer.
Integer[] B = filter(Objects::nonNull, A, Integer[]::new);

// Hacer algo con B
// ...
```

La función `filter` solo es un wrapper del método [`Stream.filter()`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html#filter-java.util.function.Predicate-) para hacer corto el ejemplo y no espantar a nadie. En otros lenguajes de programación, [como JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript/Referencia/Objetos_globales/Array/filter), es más fácil hacer este tipo de cosas.

```java
public static <T> T[] filter(Predicate<T> f, T[] arr, IntFunction<T[]> generator) {
    return Arrays.stream(arr)
            .filter(f)
            .toArray(generator);
}
```

### Operadores de listas
¿Qué tal si en lugar de escribir ciclos solo escribes qué resultado esperas? Ya vimos el operador de `filter` como un sustituto del ciclo `for` en cierto escenario. Sin embargo, este no es el único operador de esta índole. En Java, estos operadores son disponibles gracias a la clase [`java.util.Stream`](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html). Oracle tiene un par de artículos ([Parte 1](https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html), [Parte 2](https://www.oracle.com/technical-resources/articles/java/architect-streams-pt2.html)) donde se exploran las acciones que permite la API.

### Funciones lambda
Esta notación nos permite, entre otras cosas, crear funciones sin necesidad de que pertenezcan a una clase. Recomiendo leer [este artículo](https://www.adictosaltrabajo.com/2015/12/04/expresiones-lambda-con-java-8/) que explica qué son y los diferentes escenarios donde se pueden usar.