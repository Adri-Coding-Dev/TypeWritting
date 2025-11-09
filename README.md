# 🖋️ Speed Writing

**Speed Writing** es un juego de escritura rápida desarrollado en **Java con JavaFX**, diseñado para medir y mejorar la velocidad y precisión de los jugadores al escribir. Esta es la **Versión 1.0**, con interfaz moderna, modos de juego básicos y cálculo de estadísticas en tiempo real.

---

## 🎯 Objetivo del juego

El objetivo principal es escribir el texto que aparece en pantalla lo más rápido y preciso posible antes de que se agote el tiempo o sin cometer errores en el modo supervivencia.

---

## ⚙️ Características de la Versión 1.0

- **Interfaz gráfica con JavaFX**  
  - Panel central con texto objetivo y campo de escritura.  
  - Barra de progreso que muestra el avance del jugador.  
  - Contador de tiempo dinámico.  
  - Botones para reiniciar o volver al menú.  

- **Modos de juego básicos**
  - **Modo Tiempo:** Configurable (60 segundos por defecto).  
  - **Modo Supervivencia:** Escribe sin cometer errores, mide velocidad y precisión.  

- **Estadísticas en tiempo real**
  - Caracteres correctos y totales.  
  - Precisión en porcentaje.  
  - Velocidad de escritura en WPM (Words Per Minute).  

- **Fácil de iniciar y jugar**  
  - No requiere configuración compleja.  
  - Control completo desde el teclado.

---

## 🛠️ Tecnologías usadas

- **Java 21**
- **JavaFX 21**  
- IDE recomendado: **Eclipse**  
- Arquitectura basada en **MVC** (Modelo-Vista-Controlador)  

---

## 🏗️ Estructura del proyecto
```text

SpeedWriting/
|
|- src/
| |- controller/
| | |- MainMenuController.java
| | |- GameController.java
| | |- ResultController.java
| |
| |- model/
| |  |- GameStats.java
| |  |- WordGenerator.java
| |
| |- resources/
| |  |- style.css
| |
| |- view/
| |  |- main_menu.fxml
| |  |- result.fxml
| |  |- game.fxml
| |
| |- main/
|    |- Main.java
|
|- README.md
```
---

## 🚀 Cómo ejecutar el proyecto

1. **Clonar el repositorio**:

```bash
git clone https://github.com/Adri-Coding-Dev/TypeWritting
```
2. **Abrir el proyecto en Eclipse.**

3.- **Configurar JavaFX en las propiedades del proyecto:**

4.- **Añadir librerías JavaFX al Build Path.**

5.- **Configurar VM arguments:**

```cpp
Copiar código
--module-path "RUTA_A_TU_FX" --add-modules javafx.controls,javafx.fxml
Ejecutar la clase Main.java.
```

## 🎮 Uso
Selecciona el modo de juego desde el menú principal.

Presiona "Iniciar Juego".

Escribe el texto que aparece en pantalla:

El juego mide la velocidad y precisión automáticamente.

Al terminar, se mostrará un resumen de resultados:

Caracteres correctos

Total de caracteres

Precisión (%)

Velocidad en WPM

Puedes reiniciar el juego o volver al menú principal usando los botones inferiores.

💡 Posibles mejoras futuras (Versión 2.0)
Perfiles de jugadores con estadísticas guardadas.

Modos de tiempo personalizables (30s, 1min, 2min, 3min).

Temas y colores personalizables para la interfaz.

Base de datos para guardar récords y velocidad máxima.

Ranking online y logros.

Textos aleatorios y categorías de dificultad.

## 📄 Licencia
Este proyecto es open-source, libre para estudio y modificación.
No se permite uso comercial sin autorización del autor.

## ✍️ Autor
Adrián (Adri-Coding-Dev) — Desarrollador y diseñador del juego.

Contacto: [adricoding647@gmail.com]
---