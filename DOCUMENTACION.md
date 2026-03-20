# Documentación del proyecto - App de compra con RecyclerView

## 1. Objetivo de la actividad

En esta actividad he hecho una aplicación Android en Kotlin para practicar RecyclerView.

La app tiene dos pantallas:

- Pantalla principal con una lista de productos.
- Pantalla de carrito con el resumen de la compra.

Cada producto tiene nombre, precio e imagen. También se pueden sumar y restar unidades, ver el total de artículos y ver el precio total actualizado en tiempo real.

---

## 2. Herramientas usadas

- Android Studio
- Kotlin
- RecyclerView
- Emulador Android
- Git y GitHub

---

## 3. Estructura del proyecto

Archivos principales que he usado:

- Product.kt
- ProductAdapter.kt
- ProductManager.kt
- MainActivity.kt
- CartActivity.kt
- CartAdapter.kt

Layouts principales:

- activity_main.xml
- product_item.xml
- activity_cart.xml
- cart_item.xml

---

## 4. Explicación del funcionamiento

### 4.1 Pantalla principal

En la pantalla principal se muestra una lista de productos con RecyclerView.

Cada item tiene:

- Imagen del producto
- Nombre
- Precio
- Botón para añadir unidades (+)
- Botón para quitar unidades (-)

Cuando pulso + o -, se actualizan:

- El número de unidades de ese producto
- El total de artículos
- El precio total de la compra

Además, hay un botón para ir al carrito.

### 4.2 Pantalla de carrito

En la segunda pantalla también se usa RecyclerView para mostrar solo los productos que tienen cantidad mayor que 0.

En esta pantalla se puede:

- Ver el resumen de productos seleccionados
- Volver a la pantalla anterior
- Confirmar compra

Cuando confirmo compra:

- Se muestra un mensaje de confirmación
- Se imprime en consola un resumen de lo comprado

---

## 5. Capturas de pantalla

Aquí van las capturas de la app funcionando.

### 5.1 Pantalla principal al iniciar

![Pantalla principal](capturas/01_pantalla_principal.png)

Breve explicación: aquí se ve la lista inicial de productos.

### 5.2 Añadiendo unidades

![Añadiendo productos](capturas/02_sumando_productos.png)

Breve explicación: se ve cómo aumentan las unidades con el botón +.

### 5.3 Total actualizado

![Total actualizado](capturas/03_total_actualizado.png)

Breve explicación: el precio total y número de items cambian en tiempo real.

### 5.4 Pantalla de carrito

![Pantalla carrito](capturas/04_carrito.png)

Breve explicación: aparece el resumen de productos seleccionados.

### 5.5 Confirmación de compra

![Confirmación compra](capturas/05_confirmacion.png)

Breve explicación: al confirmar, sale el mensaje de compra simulada.

### 5.6 Consola con resumen

![Consola resumen](capturas/06_logcat_resumen.png)

Breve explicación: en Logcat se imprime qué productos se compran.

---

## 6. Problemas encontrados y soluciones

### Problema 1: errores de dependencias Kotlin/Gradle

Al principio tuve errores de librerías duplicadas de Kotlin.

Solución: ajustar versiones y sincronizar Gradle hasta dejar dependencias compatibles.

### Problema 2: la app se cerraba al hacer scroll

La app petaba con error de bitmap demasiado grande al mostrar imágenes.

Solución: reducir resolución/peso de imágenes y usar formatos más ligeros.

---

## 7. Conclusión personal

Con esta actividad he aprendido bastante sobre RecyclerView en Android.

Lo que más he practicado:

- Crear Adapter y ViewHolder
- Gestionar datos de una lista
- Pasar entre actividades
- Mostrar un resumen de compra
- Actualizar totales en tiempo real

También aprendí que optimizar imágenes es importante para que la app no se cierre por memoria.

---

## 8. Enlace a GitHub

Repositorio del proyecto:

[PEGAR_AQUI_ENLACE_GITHUB](https://github.com/)
