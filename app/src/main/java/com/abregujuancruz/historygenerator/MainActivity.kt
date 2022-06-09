package com.abregujuancruz.historygenerator

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abregujuancruz.historygenerator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    private val leyenda = arrayOf(
        "Quién rompa la antigua maldición adquirirá su poder",
        "El difunto Rey escondió allí toda su herencia",
        "Sólo los elegidos podrán entrar",
        "Quién lo recupere podrá conquistar su corazón",
        "Nadia volvió con vida del lugar",
        "Marcará el inicio de una nueva era",
        "Cuando se resuelva se econtrará el lugar exacto",
        "Según los rumores, en realidad no existe",
        "Si se le quita, morirá",
        "Si no se logra, una plaga azotará la región"
    )

    private val zonaInicio = arrayOf(
        "La ciénega del troll",
        "La capital imperial",
        "El camino real",
        "Un campo de batalla",
        "Un puerto",
        "Un oasis en el desierto",
        "Una ciudad enana en medio de las montañas",
        "El festival de los mercaderes",
        "Unas islas en el medio del mar",
        "La aldea de los trasgos"
    )

    private val motivosEncuentro = arrayOf(
        "Bebiendo unas cervezas",
        "Por un cartel de *** recompesa *** ",
        "Por un familiar en común",
        "Porque estuvieron en la mismas batallas",
        "En una subasta",
        "Peleándose en la taberna",
        "Por una carta anónima de reunión",
        "Por compartir la Fe",
        "Compañeros mercenarios",
        "Poseedores del mismo objeto"
    )

    private val patron = arrayOf(
        "Un mercader rico",
        "El consejo de sabios",
        "Una madre indefensa",
        "El jefe de una banda de ladrones",
        "Un dragón",
        "Un mago loco",
        "Un objeto mágico",
        "Una elfa encapuchada",
        "Un mercader con un mapa",
        "El capitán de la guardia"
    )

    private val reunion = arrayOf(
        "Por la noche en la taberna cerca del puerto",
        "En una lujosa mansión en el barrio noble",
        "En la parte trasera de la armería",
        "En la corte real",
        "En la caverna oculta en la cascada",
        "En la universidad del pueblo",
        "En la caravana",
        "Durante un ritual religioso",
        "En las mazmorras del castillo",
        "En una cama del burdel"
    )

    private val misterioInic = arrayOf(
        "Una obra de arte robada",
        "Un cadáver abandonado",
        "Unas tumbas saqueadas",
        "El secuestro de un noble",
        "La búsqueda de un niño perdido",
        "Una extraña luz",
        "Falta de suministros en el pueblo",
        "Ruidos en las alcantarillas",
        "La aparición de un monstruo",
        "Leyes injustas y estrictas"
    )

    private val motivacion = arrayOf(
        "Promesa de ascenso",
        "Conseguir un objeto poderoso",
        "Saciar tu sed de venganza",
        "Conquistar el lugar",
        "Explorar lugares insólitos",
        "Devolver un favor",
        "Pagar una deuda",
        "Fortuna inimaginable",
        "Títulos",
        "Limpiar a la competencia"
    )

    private val contactos = arrayOf(
        "El director de la Universidad",
        "Un ex-capitán semiorco",
        "Un fallecido que vio algo",
        "Un preso loco",
        "El anciano druida del bosque",
        "Las sirenas de la isla Cantora",
        "El guardia de la mazmorra",
        "Un explorador de la realeza",
        "El elegido de tu Dios",
        "La/El tabernera/o"
    )

    private val equipoApoyo = arrayOf(
        "Una caravana",
        "Una armadura",
        "Permiso de la realeza para arrasar con todo",
        "Un curandero",
        "Viales de oro",
        "Un símbolo sagrado",
        "Palabras de ánimo",
        "Un martillo enano",
        "Set de mapas",
        "Una bolsa de contención"
    )

    private val pistas1 = arrayOf(
        "Un trozo de vestimenta",
        "Huellas en el suelo",
        "Una casa antigua",
        "Mensajes rúnicos grabados en la piel",
        "Sombras en el callejón la noche anterior",
        "Se los vio juntos",
        "Esas monedas pertenecen ",
        "Estaba obsesionado",
        "El sacerdote tuvo visiones y lo vio",
        "Esos orcos siempre están implicados"
    )

    private val pistas2 = arrayOf(
        "Un ladrón encapuchado",
        "Alguien intentó envenenarlo",
        "Una condena corrupta",
        "Jinetes exploradores",
        "Los vecinos se oponen a las visitas",
        "Los guardias impiden la entrada",
        "Mercenarios que intentan interceptar el mensaje",
        "Disturbios en las calles",
        "Un hechizo peligroso",
        "Animal furioso"
    )

    private val acceso = arrayOf(
        "Un derrumbe obliga a cambiar el rumbo",
        "Escalar una montaña",
        "Introducirse en los barrios bajos de la ciudad",
        "Acceder a la corte real sin llamar la atención",
        "Sumergirse al océano/mar/laguna/río/lago",
        "Alcanzar el destino antes que el enemigo",
        "Encontrar al dragón y hacer que salga",
        "Largo viaje hacia un bosque inexplorado",
        "Camino como guardaespaldas (arduo camino)",
        "Un teletransporte por portal"
    )

    private val puestoAvanzado = arrayOf(
        "Un molino abandonado",
        "Una taberna en medio de la tormenta",
        "Una aldea de centauros",
        "Un iglú",
        "Una iglesia con un sacerdote amable",
        "Una torre de vigilancia en lo alto de la colina",
        "Un campamento improvisado al frente de la gran puerta",
        "En las mazmorras, luego de ser aprisionados",
        "Un gran comedor lleno de personajes dormidos",
        "Un claro en un bosque"
    )

    private val dungeon = arrayOf(
        "Academia militar del reino enemigo",
        "Los mausoleos prohibidos de la iglesia",
        "Las cavernas de los hombre-lagarto",
        "Una fábrica abandonada",
        "El gremio de los ladrones",
        "La gran torre del maligno hechicero",
        "El galeón del capitán",
        "El monasterio de fuego/aire/tierra/agua/luz/oscuridad",
        "La tumba del conquistador",
        "La granja del pastor anciano"
    )

    private val peligrosLugar = arrayOf(
        "Lugar inundado",
        "El mago colocó muchas trampas",
        "Un muro ilusorio lo rodea, nada es lo que parece",
        "Allí era el lugar de reposo de muchos hombres peligrosos",
        "Está construido en un lugar inestable",
        "Los desechos mágicos son tantos, que los conjuros no funcionan bien",
        "El lugar tiene muchos pasadizos secretos",
        "Una hidra gigante cuida el lugar, pero se encuentra dormida",
        "Un olor nauseabundo invade cada rincón",
        "La pureza es tal que no se puede manchar de sangre el lugar"
    )

    private val decoracion = arrayOf(
        "Velas",
        "Moho",
        "Obras de arte",
        "Pinturas graciosas",
        "Signos de combate",
        "Símbolos religiosos",
        "Decoración invisible",
        "Restos de comida por todos lados",
        "Notas e información en cada objeto",
        "Aspecto militar acorazado"
    )

    private val enemigosSecundarios = arrayOf(
        "Muertos vivientes",
        "Guardias renegados",
        "Tribu de trasgos",
        "Fanáticos religiosos",
        "Niños enojados",
        "Objetos animados",
        "Medianos ladrones",
        "Ciudadanos engañados",
        "Animales enloquecidos",
        "Mercaderes agresivos"
    )

    private val momentoPjGracioso = arrayOf(
        "Cocinero torpe",
        "Obispo tartamudo",
        "Rotura de arma en el peor momento",
        "Llave falsa",
        "El mapa se mancha de bebida",
        "Enemigo olvidadizo",
        "Bufón apresado",
        "Caída descuidada",
        "Enemigo altanero es acorralado",
        "Viejo verde"
    )

    private val momentoPjDrama = arrayOf(
        "Muerte de la enamorada",
        "La salida fue tapada por un derrumbe",
        "El enemigo huyó, demasiado tarde",
        "Apresan al grupo para cocinarlos",
        "Desatan una maldición sobre sí mismos",
        "Un personaje cuelga de un precipicio",
        "El pueblo los culpa por un acto que no cometieron",
        "Por órdenes, no pueden ingresar al sitio elegido",
        "Inocente sacrificado sin motivo",
        "Le robaron su objeto más preciado"
    )

    private val zonaEspecial = arrayOf(
        "Sala del trono",
        "Basurero",
        "Cripta gigante",
        "Guardería",
        "Sala de tortura",
        "Balcón con increíbles vistas",
        "Zona de entrenamiento",
        "Calabozo vacío con puertas secretas",
        "Centro de control de máquinas enanas",
        "Habitación del tesoro"
    )

    private val desafioEspecial = arrayOf(
        "Cubo gelatinoso",
        "Ogro hechicero",
        "Hidra domesticada",
        "Minotauro Berserker",
        "Un juez supremo",
        "Una espada mágica",
        "Un demonio atrapado",
        "Un guardaespaldas profesional",
        "Un sacerdote que guía y bendice los pasos del enemigo",
        "Un dragón enfermo"
    )

    private val ayudaInesperada = arrayOf(
        "Los enemigos de tus enemigos",
        "El propio patrón",
        "La guardia de la ciudad",
        "Los lacayos se vuelven entre sí",
        "En la biblioteca se encuentra una nueva pista",
        "El enemigo enferma",
        "Una muerto, revive",
        "Un amigo traiconero, vuelve",
        "Ayuda divina",
        "El pueblo nos apoya"
    )

    private val decisionesImportantes = arrayOf(
        "Seguir la ley o hacer justicia por mano propia",
        "Devolver los objetos o quedárselos",
        "Atacar por sorpresa o directo",
        "Respetar a los dioses o no",
        "Extender el rumor o guardarlo",
        "Estudiar el artefacto o destruirlo",
        "Gastar hasta el último recurso o volver por suministros",
        "Pelear o escapar",
        "Atacar en la guarida o esperar a que salgan",
        "Noche o día"
    )

    private val traiciones = arrayOf(
        "Resultó ser del otro bando",
        "El patrón estaba involucrado",
        "Debía ser destuido pero en realidad ayuda",
        "Emboscada",
        "Hay un topo en el grupo",
        "Llegaste tarde o a otro lugar",
        "El malo era en realidad el bueno",
        "Éramos los únicos que no conocíamos la verdad",
        "Sufres trastornos de personalidad",
        "Un amigo vende nuestra ubicación al enemigo"
    )

    private val jefe = arrayOf(
        "Un dragón rojo/otro color",
        "Una madre enfurecida",
        "El tabernero más famoso de la ciudad",
        "Un antiguo capitán de la guardia",
        "El mano del rey",
        "La sacerdotisa sagrada",
        "El vagabundo errante",
        "El ladrón enmascarado",
        "Un titán",
        "Un golem"
    )

    private val tesoro = arrayOf(
        "Montaña de monedas de un antiguo imperio",
        "Un cuadro gigante del mejor pintor",
        "Un arma sagrada",
        "Una armadura reluciente",
        "Un mapa de aventura",
        "Ropas, mudas y utencillos caros",
        "Las armas de los caídos",
        "Un cetro de poder",
        "El Cáliz de rubíes",
        "Jade y diamantes"
    )

    private val recompensa = arrayOf(
        "Tierras",
        "Fama",
        "Honor",
        "Ascenso",
        "Lugar para vivir",
        "Comida caliente",
        "Barco",
        "Beso de la princesa",
        "El favor de un dios",
        "Un banquete"
    )

    private val repercusiones = arrayOf(
        "Recomensa por nuestra cabeza",
        "Escapó y busca vengarse",
        "Somos los héroes y todos piden nuestra ayuda",
        "Uno de nosotros fue atrapado",
        "Nuestras convicciones se debilitaron",
        "Empezás a tener seguidores",
        "Destapa una conspiración",
        "Provoca una avalancha",
        "Debemos mantenernos ocultos",
        "Haces enojar a una poderosa organizacion/etc"
    )


    private val arrayControl = IntArray(28)
    private val frases = arrayOfNulls<String>(28)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.btnGenerate.setOnClickListener { init() }


    }

    private fun init(){
        for (i in 0..27) {
            arrayControl[i] = (Math.random() * 9).toInt() + 1
        }

        frases[0] = leyenda[arrayControl[0]]
        frases[1] = zonaInicio[arrayControl[1]]
        frases[2] = motivosEncuentro[arrayControl[2]]
        frases[3] = patron[arrayControl[3]]
        frases[4] = reunion[arrayControl[4]]
        frases[5] = misterioInic[arrayControl[5]]
        frases[6] = motivacion[arrayControl[6]]
        frases[7] = contactos[arrayControl[7]]
        frases[8] = equipoApoyo[arrayControl[8]]
        frases[9] = pistas1[arrayControl[9]]
        frases[10] = pistas2[arrayControl[10]]
        frases[11] = acceso[arrayControl[11]]
        frases[12] = puestoAvanzado[arrayControl[12]]
        frases[13] = dungeon[arrayControl[13]]
        frases[14] = peligrosLugar[arrayControl[14]]
        frases[15] = decoracion[arrayControl[15]]
        frases[16] = enemigosSecundarios[arrayControl[16]]
        frases[17] = momentoPjGracioso[arrayControl[17]]
        frases[18] = momentoPjDrama[arrayControl[18]]
        frases[19] = zonaEspecial[arrayControl[19]]
        frases[20] = desafioEspecial[arrayControl[20]]
        frases[21] = ayudaInesperada[arrayControl[21]]
        frases[22] = decisionesImportantes[arrayControl[22]]
        frases[23] = traiciones[arrayControl[23]]
        frases[24] = jefe[arrayControl[24]]
        frases[25] = tesoro[arrayControl[25]]
        frases[26] = recompensa[arrayControl[26]]
        frases[27] = repercusiones[arrayControl[27]]

        val adapter = ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, frases)
        b.listViewHistory.adapter = adapter

        Toast.makeText(
            applicationContext,
            "Presiona cada item para más información",
            Toast.LENGTH_LONG
        ).show()

        b.listViewHistory.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> Toast.makeText(applicationContext, "Leyenda", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(applicationContext, "Zona de inicio", Toast.LENGTH_SHORT).show()
                2 -> Toast.makeText(
                    applicationContext,
                    "Motivos para encontrarse",
                    Toast.LENGTH_SHORT
                ).show()
                3 -> Toast.makeText(applicationContext, "Patrón", Toast.LENGTH_SHORT).show()
                4 -> Toast.makeText(applicationContext, "Lugar de reunión", Toast.LENGTH_SHORT)
                    .show()
                5 -> Toast.makeText(applicationContext, "Misterio inicial", Toast.LENGTH_SHORT)
                    .show()
                6 -> Toast.makeText(applicationContext, "Motivación", Toast.LENGTH_SHORT).show()
                7 -> Toast.makeText(applicationContext, "Contactos", Toast.LENGTH_SHORT).show()
                8 -> Toast.makeText(applicationContext, "Equipo de apoyo", Toast.LENGTH_SHORT)
                    .show()
                9 -> Toast.makeText(applicationContext, "Pistas 1", Toast.LENGTH_SHORT).show()
                10 -> Toast.makeText(applicationContext, "Pistas 2", Toast.LENGTH_SHORT).show()
                11 -> Toast.makeText(
                    applicationContext,
                    "Acceso/Viaje/Transporte",
                    Toast.LENGTH_SHORT
                ).show()
                12 -> Toast.makeText(applicationContext, "Puesto avanzado", Toast.LENGTH_SHORT)
                    .show()
                13 -> Toast.makeText(
                    applicationContext,
                    "Dungeon/Lugar de exploración",
                    Toast.LENGTH_SHORT
                ).show()
                14 -> Toast.makeText(
                    applicationContext,
                    "Peligros innatos/Leyenda del lugar",
                    Toast.LENGTH_SHORT
                ).show()
                15 -> Toast.makeText(applicationContext, "Decoración", Toast.LENGTH_SHORT).show()
                16 -> Toast.makeText(applicationContext, "Enemigos secundarios", Toast.LENGTH_SHORT)
                    .show()
                17 -> Toast.makeText(
                    applicationContext,
                    "Momento: personaje gracioso",
                    Toast.LENGTH_SHORT
                ).show()
                18 -> Toast.makeText(
                    applicationContext,
                    "Momento: personaje dramático",
                    Toast.LENGTH_SHORT
                ).show()
                19 -> Toast.makeText(
                    applicationContext,
                    "Zona especial/Habitación especial",
                    Toast.LENGTH_SHORT
                ).show()
                20 -> Toast.makeText(applicationContext, "Desafío especial", Toast.LENGTH_SHORT)
                    .show()
                21 -> Toast.makeText(applicationContext, "Apoyo inesperado", Toast.LENGTH_SHORT)
                    .show()
                22 -> Toast.makeText(
                    applicationContext,
                    "Decisiones importantes",
                    Toast.LENGTH_SHORT
                ).show()
                23 -> Toast.makeText(applicationContext, "Traiciones", Toast.LENGTH_SHORT).show()
                24 -> Toast.makeText(applicationContext, "Jefe", Toast.LENGTH_SHORT).show()
                25 -> Toast.makeText(applicationContext, "Tesoro", Toast.LENGTH_SHORT).show()
                26 -> Toast.makeText(applicationContext, "Recompensa", Toast.LENGTH_SHORT).show()
                27 -> Toast.makeText(applicationContext, "Repercusiones", Toast.LENGTH_SHORT).show()
            }
        }
    }



}