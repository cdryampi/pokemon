/*
* Reto #35
* BATALLA POKÉMON
* Fecha publicación enunciado: 29/08/22
* Fecha publicación resolución: 06/09/22
* Dificultad: MEDIA
*
* Enunciado: Crea un programa que calcule el daño de un ataque durante una batalla Pokémon.
* - La fórmula será la siguiente: daño = 50 * (ataque / defensa) * efectividad
* - Efectividad: x2 (súper efectivo), x1 (neutral), x0.5 (no es muy efectivo)
* - Sólo hay 4 tipos de Pokémon: Agua, Fuego, Planta y Eléctrico (buscar su efectividad)
* - El programa recibe los siguientes parámetros:
*  - Tipo del Pokémon atacante.
*  - Tipo del Pokémon defensor.
*  - Ataque: Entre 1 y 100.
*  - Defensa: Entre 1 y 100.
*
* Información adicional:
* - Usa el canal de nuestro Discord (https://mouredev.com/discord) "🔁reto-semanal"
*   para preguntas, dudas o prestar ayuda a la comunidad.
* - Tienes toda la información sobre los retos semanales en
*   https://retosdeprogramacion.com/semanales2022.
*
*/

// estructura del programa

enums:
    - tipo: Agua, Fuego, Planta, Eléctrico
    
    PokemonAtaqueClase: Definimos todos los tipos de ataques de los pokémon
        muyEfectivo
        neutral
        pocoEfectivo
        noEfectivo

    PokemonEstado: Definimos todos los estados de los pokémon
        paralizado
        envenenado
        normal

    PokemonTipo: Definimos todos los tipos de pokémon
        agua
        fuego
        planta
        electrico

    PokemonAtaque: Definimos todos los ataques de los pokemons
        ESPECIAL,
        BASICO,
        UNICO,
        DEFENSA

controllers:
    PokemonBatalla: Controlador de los pokémon
        nombre: Nombre del pokémon
        tipo: Tipo del pokémon
        ataque: Ataque del pokémon
        defensa: Defensa del pokémon
        estado: Estado del pokémon
        vida: Vida del pokémon
        atacar: Ataca a otro pokémon
            otroPokemon: Otro pokémon
        recibirAtaque: Recibe un ataque
            ataque: Ataque recibido
        cambiarEstado: Cambia el estado del pokémon
            estado: Nuevo estado del pokémon
        cambiarVida: Cambia la vida del pokémon
            vida: Nueva vida del pokémon
        cambiarTipo: Cambia el tipo del pokémon
            tipo: Nuevo tipo del pokémon
        cambiarAtaque: Cambia el ataque del pokémon
            ataque: Nuevo ataque del pokémon
        cambiarDefensa: Cambia la defensa del pokémon
            defensa: Nueva defensa del pokémon
        cambiarNombre: Cambia el nombre del pokémon
            nombre: Nuevo nombre del pokémon
        mostrar: Muestra los datos del pokémon
    PokemonAtaque: Controlador de los ataques de los pokémon
        tipo: Tipo del ataque
        efectividad: Efectividad del ataque
        calcularDaño: Calcula el daño del ataque
            ataque: Ataque del pokémon
            defensa: Defensa del pokémon
        mostrar: Muestra los datos del ataque
    PokemonTipo: Controlador de los tipos de los pokémon
        tipo: Tipo del pokémon
        efectividad: Efectividad del tipo
        mostrar: Muestra los datos del tipo
    ListarClass
    AtaqueClass+DefensorClass
data:
    PokemonDataParceable: Dato del pokemon ganador
        nombre: Nombre del pokémon
        tipo: Tipo del pokémon
        ataque: Ataque del pokémon
        defensa: Defensa del pokémon
        estado: Estado del pokémon
        vida: Vida del pokémon

models:
    pokemon: Modelo de los pokémon
        nombre: Nombre del pokémon
        tipo: Tipo del pokémon
        ataque: Ataque del pokémon
        defensa: Defensa del pokémon
        estado: Estado del pokémon
        vida: Vida del pokémon

interfaces:
    PokemonAtaque: Interfaz de los ataques de los pokémon
        tipo: Tipo del ataque
        efectividad: Efectividad del ataque
        calcularDaño: Calcula el daño del ataque
            ataque: Ataque del pokémon
            defensa: Defensa del pokémon
        mostrar: Muestra los datos del ataque

    PokemonDefensa: Interfaz para la defensa de pokemon
        calcula subir estadisticas
        calcula bajar estadisticas
        calcula cambiar estado

//opcional
graficos:
    mainActivity1:
    Spinner: muestra un spinner con selectores de pokemons (x2) atacante y defensor
    ButtonBatallar: envia los datos de los pokemons seleccionados a la vista
    mainActivity2:
    ButtonReset: resetea los datos de los pokemons
    CardView: muestra los datos de los pokemons(x2) atacante y defensor
    ButtonVolver: vuelve a la vista anterior
    SpinnerAtaque: ataques de los pokemons
    ButtonAtacar: envia los datos de los ataques a la vista hasta que uno de los pokemons muera
    ColorPantalla: cambia el color de la pantalla cuando un pokemon muere