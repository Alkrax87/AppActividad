package com.example.appactividad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class bnb extends AppCompatActivity {

    TextView name, description, price;
    ImageView icon;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bnb);

        name = (TextView) findViewById(R.id.txtName);
        description = (TextView) findViewById(R.id.txtDescription);
        price = (TextView) findViewById(R.id.price);
        requestQueue = Volley.newRequestQueue(this);
        icon = (ImageView) findViewById(R.id.iconCrypto);
        String nameCrypto = getIntent().getStringExtra("name");

        if (nameCrypto.equals("BNB")){
            name.setText("BNB / Binance Coin");
            icon.setBackgroundResource(R.drawable.bnb);
            jsonRequest(0);
            description.setText("¿Qué es Binance Coin (BNB)?\n" +
                    "BNB se lanzó a través de una oferta inicial de monedas en 2017, 11 días antes de que el exchange de criptomonedas Binance se pusiera en marcha. Originalmente se emitió como un token ERC-20 que se ejecutaba en la red de Ethereum, con un suministro total limitado a 200 millones de monedas y 100 millones de BNB ofrecidos en la ICO. Sin embargo, las monedas BNB ERC-20 se intercambiaron con BEP2 BNB en una proporción de 1:1 en abril de 2019 con el lanzamiento de la red principal de Binance Chain, y ahora ya no están alojadas en Ethereum.\n" +
                    "\n" +
                    "BNB se puede utilizar como método de pago, un token de utilidad para pagar las tarifas en el exchange de Binance y para participar en las ventas de tokens en la plataforma de lanzamiento de Binance. BNB también alimenta a Binance DEX (exchange descentralizado).\n" +
                    "\n" +
                    "¿Se puede minar BNB?\n" +
                    "No puedes minar BNB como lo harías con una criptomoneda de proof-of-work, ya que la blockchain de Binance utiliza el mecanismo de consenso Byzantine Fault Tolerance (BFT). En cambio, hay validadores que ganan asegurando la red validando bloques.\n" +
                    "\n" +
                    "¿Qué significa la quema de BNB?\n" +
                    "Antes de que BNB migrara a Binance Chain, Binance realizaba el quemado de monedas en la red de Ethereum utilizando una función de quemado de contratos inteligentes. La cantidad de monedas que quema Binance se basa en la cantidad de operaciones del exchange durante tres meses. Desde el lanzamiento de Binance Chain, la quema de monedas BNB ya no tienen lugar en la red de Ethereum y ahora usan un comando específico en Binance Chain, en lugar de un contrato inteligente.\n" +
                    "\n" +
                    "¿Cómo se compra BNB?\n" +
                    "Puedes comprar BNB en el exchange de criptomonedas de Binance con una transferencia bancaria o giro, una tarjeta de crédito o débito, o en cualquier otro exchange que ofrezca la criptomoneda.");
        } else if (nameCrypto.equals("AVAX")){
            name.setText("AVAX / Avalanche");
            icon.setBackgroundResource(R.drawable.avax);
            jsonRequest(2);
            description.setText("¿Qué es Avalanche (AVAX)?\n" +
                    "Avalanche es una cadena de bloques de capa uno que funciona como una plataforma para aplicaciones descentralizadas y redes de cadenas de bloques personalizadas. Es uno de los rivales de Ethereum, y tiene como objetivo el desbancar a Ethereum como la cadena de bloques más popular para contratos inteligentes. Su objetivo es lograrlo al tener una mayor producción de transacciones de hasta 6500 transacciones por segundo sin comprometer la escalabilidad.\n" +
                    "\n" +
                    "Esto es posible gracias a la arquitectura única de Avalanche. La red Avalanche consta de tres cadenas de bloques individuales: X-Chain, C-Chain y P-Chain. Cada cadena tiene un propósito distinto, que es radicalmente diferente del enfoque que usan Bitcoin y Ethereum, es decir, hacer que todos los nodos validen todas las transacciones. Las cadenas de bloques Avalanche incluso utilizan diferentes mecanismos de consenso en función de sus casos de uso.\n" +
                    "\n" +
                    "Después del lanzamiento de su red principal en 2020, Avalanche ha trabajado en el desarrollo de su propio ecosistema de DApps y DeFi. Diferentes proyectos basados en Ethereum como SushiSwap y TrueUSD se han integrado con Avalanche. Además, la plataforma trabaja constantemente para mejorar la interoperabilidad entre su propio ecosistema y Ethereum, como a través del desarrollo de puentes.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Avalanche?\n" +
                    "Avalanche fue lanzado por Ava Labs, fundado por el profesor de la Universidad de Cornell, Emin Gün Sirer, junto con Kevin Sekniqi y Yin, PhD de informática de la Universidad de Cornell, y Maofan, “Ted\" Yin. Gün Sirer es un veterano en la investigación criptográfica, ya que diseñó una moneda virtual conceptual de igual a igual seis años antes del lanzamiento del documento técnico de Bitcoin. También participó en trabajos sobre soluciones de escalado de Bitcoin y en investigaciones sobre Ethereum antes del infame hackeo de del DAO en 2016.\n" +
                    "\n" +
                    "De esa investigación surgió el libro blanco que llevó a la fundación de Ava Labs en 2018. El proyecto cerró una ronda semilla en febrero de 2019 que incluía inversores como Polychain, Andreessen Horowitz y Balaji Srinivasan. Avalanche cerró su oferta inicial de monedas en 2020 en menos de 24 horas, recaudando $42 millones en el proceso.\n" +
                    "\n" +
                    "¿Qué hace que Avalanche sea único?\n" +
                    "Avalanche intenta resolver el trilema de las cadenas de bloques, que postula que las cadenas de bloques no pueden lograr un grado suficiente de descentralización a escala. Una consecuencia de esto son las altas tarifas de gas, como suele ser el caso de Ethereum.\n" +
                    "\n" +
                    "Para resolver este problema, Avalanche diseñó tres cadenas de bloques interoperables.\n" +
                    "\n" +
                    "La cadena de intercambio (X-Chain) se emplea para crear e intercambiar los tokens AVAX nativos y otros activos. Similar al estándar ERC-20 en Ethereum, estos tokens siguen un conjunto de reglas estandarizadas. Utiliza el mecanismo de consenso de Avalanche.\n" +
                    "La cadena de contratos (C-Chain) aloja contratos inteligentes y aplicaciones descentralizadas. Tiene su propia máquina virtual Avalanche, similar a la máquina virtual Ethereum, lo que permite a los desarrolladores bifurcar DApps compatibles con EVM. Utiliza el mecanismo de consenso de Snowman.\n" +
                    "La cadena de plataformas (P-Chain) coordina validadores de red, realiza un seguimiento de subredes activas y permite la creación de nuevas subredes. Las subredes son conjuntos de validadores, algo así como un cartel de validadores. Cada subred puede validar varias cadenas de bloques, pero una cadena de bloques solo puede ser validada por una subred. También utiliza el mecanismo de consenso Snowman.\n" +
                    "Esta división de tareas informáticas permite un mayor rendimiento sin comprometer la descentralización. Por ejemplo, las cadenas de bloques privadas en la red podrían requerir que los validadores de su subred estén lo suficientemente descentralizados geográficamente o que cumplan con ciertas regulaciones. Tras esta estructura modular, Avalanche mejora su interoperabilidad con otras cadenas de bloques que desean integrarse con el ecosistema Avalanche. Además, los dos mecanismos de consenso diferentes están diseñados teniendo en cuenta los requisitos de cada cadena de bloques, mejorando aún más su eficiencia.\n" +
                    "\n" +
                    "¿Cuántas monedas de Avalanche (AVAX) hay en circulación?\n" +
                    "El suministro total de AVAX es de 720 millones. La distribución del token es la siguiente:\n" +
                    "\n" +
                    "2,5 % - venta de semillas, con un 10 % lanzado en el lanzamiento de la mainnet y el resto lanzado cada tres meses.\n" +
                    "3,5 % - venta privada, con un 10 % lanzado en el lanzamiento de la mainnet y el resto lanzado cada tres meses.\n" +
                    "10 % - venta pública, con un 10 % lanzado en el lanzamiento de la mainnet y un 15 % lanzado cada tres meses durante un período de 18 meses.\n" +
                    "9,26 % - asignado a la fundación, liberado a lo largo de diez años.\n" +
                    "7 % - dotación de la comunidad, liberada durante doce meses.\n" +
                    "0,27 %: programa de incentivos de la testnet, lanzado durante un año.\n" +
                    "5 %: socios estratégicos, lanzados en un plazo de cuatro años.\n" +
                    "2,5 % - airdrops, liberadas en un plazo cuatro años.\n" +
                    "10 % - equipo, lanzado en cuatro años.\n" +
                    "Recompensas de participación del 50 %\n" +
                    "Staking AVAX actualmente proporciona una recompensa anual del 11,57 %, con el tiempo mínimo para la participación de dos semanas con un mínimo de 2.000 AVAX.\n" +
                    "\n" +
                    "¿Cómo se asegura la red de Avalanche?\n" +
                    "AVAX se comercializa en la cadena de intercambio, que sigue su propio mecanismo de consenso de Avalanche. A diferencia de la prueba de trabajo o la prueba de participación, el mecanismo de consenso de Avalanche no tiene un líder que procese transacciones que sean validadas por otros. En su lugar, todos los nodos procesan y validan las transacciones empleando un protocolo de gráfico acíclico dirigido (DAG). De esa manera, las transacciones se procesan simultáneamente y el sondeo aleatorio de los validadores garantiza que las transacciones sean correctas con certeza estadística. No hay bloques en este mecanismo de consenso, lo que permite la finalización inmediata y mejora significativamente la velocidad de la cadena de bloques.\n" +
                    "\n" +
                    "¿Dónde se puede comprar Avalanche (AVAX)?\n" +
                    "AVAX está disponible en Binance, Bitfinex, Gate.io y Kucoin.");
        } else if (nameCrypto.equals("ATOM")){
            name.setText("ATOM / Cosmos");
            icon.setBackgroundResource(R.drawable.atom);
            jsonRequest(3);
            description.setText("¿Qué es cosmos (ATOM)?\n" +
                    "En pocas palabras, Cosmos se anuncia a sí mismo como un proyecto que resuelve algunos de los \"problemas más difíciles\" que enfrenta la industria blockchain. Su objetivo es ofrecer un antídoto contra los protocolos de prueba de trabajo \"lentos, costosos, inescalables y perjudiciales para el medio ambiente\", como los utilizados por Bitcoin, al ofrecer un ecosistema de cadenas de bloques conectadas.\n" +
                    "\n" +
                    "Los otros objetivos del proyecto incluyen hacer que la tecnología blockchain sea menos compleja y difícil para los desarrolladores gracias a un marco modular que desmitifica las aplicaciones descentralizadas. Por último, pero no menos importante, un protocolo de comunicación Interblockchain facilita que las redes blockchain se comuniquen entre sí, evitando la fragmentación en la industria.\n" +
                    "\n" +
                    "Los orígenes de Cosmos se remontan a 2014, cuando se fundó Tendermint, un colaborador central de la red. En 2016, se publicó un libro blanco para Cosmos, y se realizó una venta de tokens al año siguiente. Los tokens ATOM se obtienen a través de un algoritmo híbrido de prueba de participación, y ayudan a mantener seguro el Cosmos Hub, la cadena de bloques insignia del proyecto. Esta criptomoneda también tiene un papel en la gobernanza de la red.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Cosmos?\n" +
                    "Los cofundadores de Tendermint, la puerta de entrada al ecosistema Cosmos, fueron Jae Kwon, Zarko Milosevic y Ethan Buchman. Aunque Kwon todavía figura como arquitecto principal, renunció como CEO en 2020. Sostiene que sigue siendo parte del proyecto, pero se centra principalmente en otras iniciativas. Ahora ha sido reemplazado como CEO de Tendermint por Peng Zhong, y toda la junta directiva recibió una actualización bastante sustancial. Sus objetivos incluyen mejorar la experiencia de los desarrolladores, crear una comunidad entusiasta para Cosmos y construir recursos educativos para que un mayor número de personas sean conscientes de lo que esta red es capaz de hacer.\n" +
                    "\n" +
                    "¿Qué hace que Cosmos sea único?\n" +
                    "Una preocupación importante para algunos en la industria criptográfica se centra en los niveles de fragmentación observados en las redes blockchain. Existen cientos, pero muy pocos de ellos pueden comunicarse entre sí. Cosmos tiene como objetivo darle la vuelta a esto haciendo esto posible.\n" +
                    "\n" +
                    "Cosmos se describe como \"Blockchain 3.0\", y como mencionamos anteriormente, un gran objetivo es garantizar que su infraestructura sea fácil de usar. Con este fin, el kit de desarrollo de software Cosmos se centra en la modularidad. Esto permite que una red se construya fácilmente utilizando fragmentos de código que ya existen. A largo plazo, se espera que las aplicaciones complejas sean fáciles de construir como resultado.\n" +
                    "\n" +
                    "La escalabilidad es otra prioridad, lo que significa que se pueden procesar sustancialmente más transacciones por segundo que las cadenas de bloques más anticuadas como Bitcoin y Ethereum. Si las cadenas de bloques alguna vez van a lograr la adopción general, deberán poder hacer frente a la demanda, así como a las empresas o sitios web de procesamiento de pagos existentes, o incluso ser mejores.\n" +
                    "\n" +
                    "Actualización de cuentas de Cosmos Interchain\n" +
                    "La Fundación Interchain, una organización sin fines de lucro del ecosistema Cosmos, anunció el lanzamiento de la actualización de las cuentas de Interchain el 17 de febrero de 2022. Lanzado en abril de 2021, el protocolo Inter-Blockchain Communications (IBC) es el estándar Cosmos para la interoperabilidad de blockchain. Permite que una cadena de bloques individual controle una cuenta en una cadena separada. Hay 38 proyectos que utilizan IBC actualmente, en particular Terra, cadena de Crypto.org y puente Gravity. La actualización de Interchain Accounts será la más grande para el ecosistema desde Stargate, que permitió a las cadenas de bloques de Cosmos conectarse entre sí utilizando el protocolo estandarizado para IBC por primera vez. Con Interchain Accounts, los usuarios pueden apostar, votar, intercambiar tokens y más en otras cadenas de bloques. La actualización tiene el propósito de \"permitir la componibilidad en IBC [que] permite implementar la innovación en distintas aplicaciones sin necesidad de actualizar toda la Interchain\".\n" +
                    "\n" +
                    "¿Cuántas monedas cosmos (ATOM) hay en circulación?\n" +
                    "ATOM tiene un suministro total muy específico: 260,906,513 para ser exactos. De estos, en el momento de escribir este artículo, alrededor de 203.121.910 estaban en circulación. Vale la pena señalar que estas criptomonedas no se extraen, sino que se obtienen a través de la apuesta.\n" +
                    "\n" +
                    "En enero de 2017 se realizaron dos ventas privadas, seguidas de una venta pública en abril de ese año. Esto recaudó un total de $ 16 millones, que es el equivalente a aproximadamente $ 0.10 por ATOM.\n" +
                    "\n" +
                    "Desglosando la distribución de tokens, alrededor del 80% se asignó a los inversores, mientras que el 20% restante se dividió entre dos compañías: All In Bits y la Fundación Interchain.\n" +
                    "\n" +
                    "Cosmos ha comparado los tokens ATOM con los ASIC que se utilizan para extraer Bitcoin. Como explicaba un documento técnico escrito por el equipo de Tendermint: \"Es una pieza de hardware virtualizado (capital económico) que debe obtener para participar como guardián en la red\".\n" +
                    "\n" +
                    "¿Cómo se asegura la red Cosmos?\n" +
                    "Como mencionamos anteriormente, Cosmos utiliza un algoritmo de consenso de prueba de participación. Los nodos validadores que apuestan por una mayor cantidad de tokens ATOM tienen más probabilidades de ser elegidos para verificar transacciones y ganar recompensas. Los nodos que actúan de manera deshonesta son penalizados, y pueden terminar perdiendo los tokens que tenían en juego.\n" +
                    "\n" +
                    "¿Dónde se puede comprar Cosmos (ATOM)?\n" +
                    "Ahora está disponible en varios intercambios importantes: muchas personas eligen comprar Cosmos en Binance, Coinbase y OKEx.");
        } else if (nameCrypto.equals("ADA")){
            name.setText("ADA / Cardano");
            icon.setBackgroundResource(R.drawable.ada);
            jsonRequest(4);
            description.setText("¿Qué es Cardano (ADA)?\n" +
                    "Cardano es una plataforma de blockchain de prueba de participación cuyo objetivo es permitir que los usuarios que sean \"pioneros, innovadores y visionarios\" traigan consigo un cambio global positivo a la red.\n" +
                    "\n" +
                    "Este proyecto de código abierto también pretende “redistribuir el poder de las estructuras contables entre los individuos marginados\", ayudando a crear una sociedad más segura, transparente y justa.\n" +
                    "\n" +
                    "Cardano fue fundada en 2017, y las token de ADA están diseñadas para asegurar que los propietarios puedan participar en el funcionamiento de la red. Debido a esto, los que poseen esta criptomoneda tienen derecho a votar sobre cualquier cambio propuesto en el software.\n" +
                    "\n" +
                    "El equipo detrás de esta cadena de bloques en capas dice que ya han habido algunos casos de uso atractivos para su tecnología, como por ejemplo permitir que las aplicaciones descentralizadas y los contratos inteligentes se desarrollen con modularidad.\n" +
                    "\n" +
                    "Cardano es utilizado por compañías agrícolas para rastrear productos frescos del campo a la mesa; mientras que otros productos construidos en la plataforma permiten que las credenciales educativas e información personal se almacenen de una manera a prueba de manipulaciones. Además, permite a los minoristas tomar acciones drásticas contra mercancías falsificadas.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Cardano?\n" +
                    "Cardano fue fundado por Charles Hoskinson, quien también fue uno de los cofundadores de la red Ethereum. Hoskinson es el director general de IOHK, la compañía que construyó la cadena de bloques de Cardano.\n" +
                    "\n" +
                    "En una entrevista para la serie Titanes del Crypto de CoinMarketCap, Hoskinson dijo que se involucró en el mundo de las criptodivisas en 2011, dedicándose a la minería y el comercio. Explicó que su primera participación profesional en la industria llegó en 2013, cuando creó un curso sobre Bitcoin que terminó siendo tomado por 80.000 estudiantes.\n" +
                    "\n" +
                    "Además de ser un emprendedor tecnológico, Hoskinson también es matemático. En 2020, su compañía de tecnología donó varias ADA por un valor de $500.000 al laboratorio de investigación y desarrollo de la cadena de bloques de la Universidad de Wyoming.\n" +
                    "\n" +
                    "¿Qué hace que Cardano sea único?\n" +
                    "Cardano es una de las mayores cadenas de bloques en utilizar con éxito un mecanismo de consenso de pruebas de participación, el cual consume menos recursos que el algoritmo de pruebas de trabajo en el que confía Bitcoin. Aunque el gigante Ethereum se estará actualizando al PoS, esta transición solo va a tener lugar de forma gradual.\n" +
                    "\n" +
                    "El proyecto se enorgullece de asegurar que toda la tecnología desarrollada pasa por un proceso de investigación hecho por otros usuarios de la red, lo que significa que las ideas audaces pueden ser cuestionadas antes de ser validadas. Según el equipo de Cardano, este rigor académico ayuda a que la cadena de bloques sea duradera y estable, aumentando la posibilidad de que se pueda anticipar cualquier problema.\n" +
                    "\n" +
                    "En 2020, Cardano llevó a cabo una actualización Shelley que pretendía hacer que su blockchain fuese de “50 a 100 veces más descentralizada\" que otras cadenas de bloques de gran tamaño. En ese momento, Hoskinson predijo que esto abriría un camino para que cientos de activos funcionaran en su red.\n" +
                    "\n" +
                    "¿Cuántas monedas de Cardano (ADA) hay en circulación?\n" +
                    "Hay un suministro máximo de 45.000 millones de ADA, pero en el momento de escribir este artículo, había un suministro en circulación de unos 31.000 millones. Entre septiembre de 2015 y enero de 2017 se realizaron cinco rondas de ventas públicas de fichas de Cardano.\n" +
                    "\n" +
                    "Aproximadamente 2.500 millones de ADA fueron asignados a IOHK una vez lanzada la red. Por otro lado, se otorgó un ADA adicional de 2,1 mil millones a Emurgo, una empresa de tecnología de blockchain global que sirvió como entidad fundadora del protocolo Cardano. Por último, pero no menos importante, se otorgaron 648 millones de ADA a la Fundación Cardano sin fines de lucro, que pretende promover la plataforma y aumentar sus niveles de adopción.\n" +
                    "\n" +
                    "En total, alrededor del 16% del suministro total de ADA fue a los fundadores del proyecto, y el 84% restante se repartió entre los inversores.\n" +
                    "\n" +
                    "¿Cómo está asegurada la red Cardano?\n" +
                    "Cardano se mantiene segura gracias a un protocolo de punto de venta (PoS por sus siglas en inglés), \"ambientalmente sostenible y verificable\", que se conoce como Ouroboros.\n" +
                    "\n" +
                    "El proyecto dice que Ouroboros mejora las garantías de seguridad que se ofrecen mediante un mecanismo de consenso del PoW; al mismo tiempo que utiliza sustancialmente menos energía, afirmando que es cuatro veces más eficiente energéticamente que Bitcoin.\n" +
                    "\n" +
                    "Se describe como una combinación de tecnología única y mecanismos verificados matemáticamente, con psicología conductual y filosofía económica integrada para brindar un buen funcionamiento. En general, el objetivo de Ouroboros es lograr un crecimiento sostenible y ético.\n" +
                    "\n" +
                    "Un mecanismo de incentivos significa que los participantes en la red son recompensados por su participación.\n" +
                    "\n" +
                    "¿Dónde puedes comprar Cardano (ADA)?\n" +
                    "Como una de las mayores criptodivisas del mundo en términos de capitalización de mercado, no deberías tener muchas dificultades para comprar ADA en las principales bolsas, incluyendo Binance, Coinbase, eToro y HitBTC.");
        } else if (nameCrypto.equals("XTZ")){
            name.setText("XTZ / Tezos");
            icon.setBackgroundResource(R.drawable.xtz);
            jsonRequest(5);
            description.setText("¿Qué es Tezos (XTZ)?\n" +
                    "Tezos es una red de blockchain que se basa en contratos inteligentes, de una manera que no es muy diferente a la de Ethereum. Sin embargo, hay una gran diferencia: Tezos tiene como objetivo ofrecer una infraestructura más avanzada, lo que significa que puede evolucionar y mejorar con el tiempo sin que haya un peligro de una bifurcación dura. Esto es algo que tanto Bitcoin como Ethereum han sufrido desde que se crearon. Los poseedores de XTZ pueden votar sobre las propuestas de actualización de protocolos que han sido presentadas por los desarrolladores de Tezos.\n" +
                    "\n" +
                    "Esta plataforma de código abierto se autodenomina \"segura, actualizable y construida para durar\", y dice que su lenguaje de contrato inteligente proporciona la precisión que se requiere para operaciones de alto valor. Según Tezos, su enfoque principal es a prueba del futuro, por lo que “permanecerá de última generación por mucho tiempo\", lo que significa que puede adoptar desarrollos en tecnología blockchain.\n" +
                    "\n" +
                    "La tecnología que sustenta a Tezos fue propuesta por primera vez en un libro blanco que se publicó en septiembre de 2014. Después de una serie de retrasos, la red principal de Tezos se lanzó cuatro años después.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Tezos?\n" +
                    "Arthur Breitman fue el hombre que escribió el documento técnico de Tezos, y en un guiño a Satoshi Nakamoto, escribió sus obras bajo el seudónimo L. M. Goodman. Argumentó que una de las mayores fallas de Bitcoin fue la falta de un proceso de gobernanza que permitiera las contribuciones de la comunidad que utiliza la red; así como el hecho de que no se pudieron emitir nuevos tokens a través de esta cadena de bloques.\n" +
                    "\n" +
                    "Él y su esposa Kathleen fundaron una startup llamada Dynamic Ledger Solutions que tenía la tarea de escribir el código que respaldaría el protocolo de Tezos. Esta compañía fue posteriormente adquirida por la Fundación Tezos para asegurar que poseía todos los derechos de propiedad intelectual relacionados con la red.\n" +
                    "\n" +
                    "¿Qué hace que Tezos sean único?\n" +
                    "Aunque la participación es común en las cadenas de bloques, Tezos le da un giro único en este proceso. Los participantes pueden involucrarse en la gobernanza de la red a través de la \"cocción\", en la que efectivamente se validan 8.000 XTZ. Esto crea un incentivo financiero para actuar honestamente.\n" +
                    "\n" +
                    "A los usuarios se les encomienda la tarea de votar por los cambios propuestos para el código de la cadena de bloques en un procedimiento de cuatro pasos que toma aproximadamente 23 días. Las propuestas que reciben el apoyo de la gran mayoría de los participantes se ponen a prueba durante 48 horas y se aplican plenamente si cuentan con el respaldo de una supermayoría.\n" +
                    "\n" +
                    "Tezos también es único por cómo ha empezado a ser utilizado por empresas de alto perfil. En septiembre de 2020, se anunció que el gigante bancario francés Societe Generale planeaba utilizar esta cadena de bloques para experimentar con una moneda digital del banco central.\n" +
                    "\n" +
                    "Los grandes intercambios de criptomonedas como Binance y Coinbase también han revelado el apoyo a las operaciones de Tezos, lo que significa que los usuarios pueden recibir recompensas basadas en el XTZ que poseen. Esta no es una característica que se haya visto demasiado entre los activos digitales.\n" +
                    "\n" +
                    "¿Cuántas monedas de Tezos (XTZ) hay en circulación?\n" +
                    "Nuestros datos muestran que 743.862.304 XTZ están en circulación en el momento de escribir este artículo.\n" +
                    "\n" +
                    "Una venta de tokens de Tezos se realizó en julio de 2017, y durante esta ICO, se recaudó un total de 65.681 BTC y 361.122 ETH. En ese momento, esto valía $232 millones, asegurando su lugar como una de las mayores ofertas de monedas iniciales jamás realizadas.\n" +
                    "\n" +
                    "Mientras que el 80% de este suministro inicial fue a los inversores, el 20% se dividió en partes iguales entre la Fundación Tezos y Dynamic Ledger Solutions.\n" +
                    "\n" +
                    "El lanzamiento de la mainnet fue retrasado por una serie de demandas de algunos inversores descontentos, quienes argumentaron que XTZ ascendió a valores no registrados.\n" +
                    "\n" +
                    "¿Cómo está asegurada la red de Tezos?\n" +
                    "Al igual que otras cadenas de bloques, Tezos utiliza un mecanismo de consenso de pruebas de participación.\n" +
                    "\n" +
                    "Cualquiera puede convertirse en validador y contribuir al buen funcionamiento de la red haciendo un depósito de seguridad. Para incentivar el comportamiento honesto, se otorgan recompensas a aquellos que trabajan teniendo en mente los mejores intereses de la cadena de bloques. Aquellos que actúan de manera deshonesta corren el riesgo de perder su participación por completo.\n" +
                    "\n" +
                    "¿Dónde puedes comprar Tezos (XTZ)?\n" +
                    "XTZ, también conocido como \"tez\" para abreviar, puede ser comprado en la mayoría de las grandes bolsas, incluyendo Binance, Coinbase y otras.");
        } else if (nameCrypto.equals("BTC")){
            name.setText("BTC / Bitcoin");
            icon.setBackgroundResource(R.drawable.btc);
            jsonRequest(6);
            description.setText("¿Qué es Bitcoin (BTC)?\n" +
                    "Bitcoin es una criptomoneda descentralizada presentada originalmente en un documento técnico en 2008 por una persona, o grupo de personas, utilizando el alias Satoshi Nakamoto. Se lanzó poco después, en enero de 2009.\n" +
                    "\n" +
                    "El bitcoin es una moneda en línea peer-to-peer, lo que significa que todas las transacciones ocurren directamente entre los participantes, iguales e independientes, de la red sin la necesidad de que ningún intermediario les de permiso o les facilite las operaciones. Bitcoin se creó, de acuerdo con las propias palabras de Nakamoto, para permitir que “los pagos en línea se pudieran enviar directamente de una parte a otra sin pasar por una institución financiera\".\n" +
                    "\n" +
                    "Existen algunos conceptos que describen un tipo similar de moneda electrónica descentralizada antes del BTC, pero Bitcoin tiene la distinción de ser la primera criptomoneda en entrar en uso.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Bitcoin?\n" +
                    "El inventor original de Bitcoin es conocido bajo un seudónimo, Satoshi Nakamoto. Aún en el 2020, la verdadera identidad de la persona (u organización) que se encuentra detrás del alias sigue siendo desconocida.\n" +
                    "\n" +
                    "El 31 de octubre de 2008, Nakamoto publicó el documento técnico de Bitcoin, en el que se describe en detalle cómo se podría implementar una moneda digital peer-to-peer. En él propusieron utilizar un libro de contabilidad descentralizado de transacciones empaquetadas en lotes (llamados \"bloques\") y aseguradas por algoritmos criptográficos; el sistema completo más tarde se denominaría \"blockchain\".\n" +
                    "\n" +
                    "Solo dos meses después, el 3 de enero de 2009, Nakamoto extrajo el primer bloque de la red Bitcoin, conocido como el bloque génesis, lanzando así la primera criptomoneda del mundo.\n" +
                    "\n" +
                    "Sin embargo, aunque Nakamoto fue el inventor original de Bitcoin, así como el autor de su primera implementación, a lo largo de los años un gran número de personas han contribuido a mejorar el software de esta criptomoneda mediante la aplicación de parches a las vulnerabilidades, y la adición de nuevas características.\n" +
                    "\n" +
                    "El archivo del código fuente de Bitcoin en GitHub lista más de 750 colaboradores, siendo algunos de los más importantes Wladimir J van der Laan, Marco Falke, Pieter Wuille, Gavin Andresen, Jonas Schnelli, entre otros.\n" +
                    "\n" +
                    "¿Qué hace que el Bitcoin sea único?\n" +
                    "La ventaja más singular de Bitcoin proviene del hecho de que fue la primera criptodivisa que apareció en el mercado.\n" +
                    "\n" +
                    "Ha logrado crear una comunidad global, y dar nacimiento a una industria completamente nueva con millones de entusiastas que crean, invierten, comercializan y utilizan Bitcoin y otras criptodivisas en su vida cotidiana. La aparición de esta primera criptomoneda ha creado una base conceptual y tecnológica que posteriormente inspiró el desarrollo de miles de proyectos competitivos.\n" +
                    "\n" +
                    "Todo el mercado de las criptodivisas, que ahora vale más de 300.000 millones de dólares, se basa en la idea realizada por Bitcoin: dinero que puede ser enviado y recibido por cualquier persona, en cualquier lugar del mundo, sin depender de intermediarios de confianza, como bancos y empresas de servicios financieros.\n" +
                    "\n" +
                    "Gracias a su naturaleza pionera, BTC permanece en la cima de este vibrante mercado después de más de una década de existencia. Incluso después de que Bitcoin haya perdido su dominio indiscutible, sigue siendo el criptoactivo más grande, con una capitalización de mercado que fluctuó entre 100 y 200 millones de dólares en 2020, debido en gran parte a la presencia de plataformas que proporcionan opciones de uso para BTC: carteras, intercambios, servicios de pago, juegos en línea y más.\n" +
                    "\n" +
                    "¿Cuántas Bitcoin hay en circulación?\n" +
                    "El suministro total de Bitcoin está limitado por su software y nunca superará las 21.000.000 monedas. Se pueden crear nuevas monedas durante el proceso conocido como \"minería\": a medida que las transacciones son retransmitidas a través de la red, son recogidas por los mineros y empaquetadas en bloques, que a su vez están protegidos por complejos cálculos criptográficos.\n" +
                    "\n" +
                    "Como compensación por gastar sus recursos computacionales, los mineros reciben recompensas por cada bloque que añaden con éxito a la cadena de bloques. Al momento de haber sido lanzado Bitcoin, la recompensa era de 50 bitcoins por bloque: este número se reduce a la mitad con cada 210.000 nuevos bloques extraídos, que son conseguidos por la red en aproximadamente cuatro años. A partir del 2020, la recompensa por bloque se ha reducido a la mitad tres veces. Actualmente comprende 6,25 monedas de Bitcoin.\n" +
                    "\n" +
                    "El Bitcoin no fue minado con antelación, lo que significa que no se han extraído ni distribuido monedas entre los fundadores antes de que estuvieran disponibles para el público. Sin embargo, durante los primeros años de existencia de BTC, la competencia entre los mineros era relativamente baja, permitiendo a los primeros participantes de la red acumular cantidades significativas de monedas a través de la minería regular. Se cree que Satoshi Nakamoto solo posee más de un millón de Bitcoins.\n" +
                    "\n" +
                    "¿Cómo es asegurada la red de Bitcoin?\n" +
                    "Bitcoin está asegurado por el algoritmo SHA-256, que pertenece a la familia de algoritmos de autenticación hashing SHA-2, que también es utilizado por Bitcoin Cash (BCH), así como varias otras criptodivisas.\n" +
                    "\n" +
                    "¿Dónde se puede comprar Bitcoin (BTC)?\n" +
                    "El Bitcoin es, en muchos aspectos, casi sinónimo de criptomoneda, lo que significa que puedes comprarlo o venderlo en prácticamente cualquier intercambio de criptomonedas, tanto por dinero fiduciario como por otras criptomonedas. Algunos de los principales mercados en los que se puede comerciar con BTC son:\n" +
                    "\n" +
                    "Binance\n" +
                    "Coinbase Pro\n" +
                    "OKEx\n" +
                    "Kraken\n" +
                    "Huobi Global\n" +
                    "Bitfinex");
        } else if (nameCrypto.equals("ETH")){
            name.setText("ETH / Ethereum");
            icon.setBackgroundResource(R.drawable.eth);
            jsonRequest(7);
            description.setText("¿Qué es Ethereum (ETH)?\n" +
                    "Ethereum es un sistema blockchain de código abierto descentralizado que incluye su propia criptomoneda, Ether. ETH funciona como plataforma para otras numerosas criptomonedas, así como para la ejecución de contratos inteligentes descentralizados.\n" +
                    "\n" +
                    "Ethereum fue descrito por primera vez en un whitepaper de 2013 por Vitalik Buterin. Buterin, junto con otros cofundadores, aseguraron la financiación para el proyecto en una venta pública en línea en el verano de 2014 y lanzaron oficialmente la cadena de bloques el 30 de julio de 2015.\n" +
                    "\n" +
                    "El objetivo de Ethereum es convertirse en una plataforma global para aplicaciones descentralizadas, lo que permite a los usuarios de todo el mundo escribir y ejecutar software resistente a la censura, el tiempo de inactividad y el fraude.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de Ethereum?\n" +
                    "Ethereum tiene un total de ocho cofundadores, un número inusualmente grande para un proyecto de criptomonedas. Se conocieron por primera vez el 7 de junio de 2014, en Zug, Suiza.\n" +
                    "\n" +
                    "El ruso canadiense Vitalik Buterin es quizás el más conocido del grupo. Creó el documento técnico original que describió por primera vez Ethereum en 2013 y todavía trabaja en la mejora de la plataforma hasta la actualidad. Antes de ETH, Buterin fue fundador y escribió para el sitio web de noticias de Bitcoin Magazine.\n" +
                    "El programador británico Gavin Wood es posiblemente el segundo cofundador más importante de ETH, ya que codificó la primera implementación técnica de Ethereum en el lenguaje de programación C++, propuso el lenguaje de programación nativo de Ethereum, Solidity, y fue el primer jefe de tecnología de la Fundación Ethereum. Antes de Ethereum, Wood era científico investigador en Microsoft. Posteriormente, estableció la Fundación Web3.\n" +
                    "Los otros cofundadores de Ethereum son: - Anthony Di Iorio, quien escribió el proyecto durante su etapa inicial de desarrollo. - Charles Hoskinson, que desempeñó un rol principal en el establecimiento de la Fundación Ethereum con sede en Suiza y su marco legal. - Mihai Alisie, quien prestó asistencia en el establecimiento de la Fundación Ethereum. - Joseph Lubin, un empresario canadiense, que, como Di Iorio, ayudó a financiar Ethereum durante sus primeros días, y más tarde fundó una incubadora de empresas de nueva creación basada en ETH llamada ConsenSys. - Amir Chetrit, que ayudó a fundar Ethereum, pero se alejó del proyecto al principio del desarrollo.\n" +
                    "\n" +
                    "¿Qué hace que Ethereum sea único?\n" +
                    "Ethereum ha sido pionero en el concepto de una plataforma blockchain de contratos inteligentes. Los contratos inteligentes son programas informáticos que ejecutan automáticamente las acciones necesarias para cumplir un acuerdo entre varias partes a través de Internet. Se diseñaron para reducir la necesidad de intermediarios de confianza entre los contratistas, reduciendo así los costos de transacción y aumentando también la fiabilidad de las transacciones.\n" +
                    "\n" +
                    "La principal innovación de Ethereum fue el diseño de una plataforma que le permitió ejecutar contratos inteligentes utilizando blockchain, lo que refuerza aún más los beneficios ya existentes de la tecnología de contratos inteligentes. La blockchain de Ethereum fue diseñada, según el cofundador Gavin Wood, como una especie de “computadora para todo el planeta\", teóricamente capaz de hacer que cualquier programa sea más robusto, resistente a la censura y menos propenso al fraude al ejecutarlo en una red distribuida globalmente de nodos públicos\".\n" +
                    "\n" +
                    "Además de los contratos inteligentes, la blockchain de Ethereum es capaz de albergar otras criptomonedas, llamadas \"tokens\", mediante el uso de su estándar de compatibilidad ERC-20. De hecho, este ha sido el uso más común para la plataforma de ETH hasta ahora: a la fecha, se han lanzado más de 280,000 tokens compatibles con ERC. Más de 40 de estos conforman las principales 100 criptomonedas por capitalización de mercado, por ejemplo, USDT, LINK y BNB.\n" +
                    "\n" +
                    "¿Cuántas monedas de Ethereum (ETH) hay en circulación?\n" +
                    "En agosto de 2020, había alrededor de 112 millones de monedas de ETH en circulación, 72 millones de las cuales fueron emitidas en el bloque génesis —el primer bloque de la blockchain de Ethereum—. De estos 72 millones, 60 millones fueron asignados a los colaboradores iniciales a la venta de 2014 personas que financiaron el proyecto, y 12 millones fueron entregados al fondo de desarrollo.\n" +
                    "\n" +
                    "El monto restante se ha emitido en forma de recompensas de bloque a los mineros de la red de Ethereum. La recompensa original en 2015 fue de 5 ETH por bloque, luego bajó a 3 ETH a finales de 2017 y luego a 2 ETH a principios de 2019. El tiempo promedio que toma minar un bloque de Ethereum es alrededor de 13-15 segundos.\n" +
                    "\n" +
                    "Una de las principales diferencias entre la economía de Bitcoin y Ethereum es que este último no es deflacionario, es decir, su oferta total no es limitada. Los desarrolladores de Ethereum justifican esto al no querer tener un \"presupuesto fijo de seguridad\" para la red. Poder ajustar la tasa de emisión de ETH a través de consenso permite a la red mantener la emisión mínima necesaria para una seguridad adecuada.\n" +
                    "\n" +
                    "¿Cómo se asegura la red Ethereum?\n" +
                    "Para agosto de 2020, Ethereum está asegurado mediante el algoritmo de proof-of-work Ethash, perteneciente a la familia de funciones de hash Keccak.\n" +
                    "\n" +
                    "Sin embargo, hay planes para hacer la transición de la red a un algoritmo de proof-of-stake vinculado a la actualización principal de Ethereum 2,0, programada para iniciarse a finales de 2020 o a principios de 2021.\n" +
                    "\n" +
                    "¿Dónde se puede comprar Ethereum (ETH)?\n" +
                    "Dado el hecho de que Ethereum es la segunda criptomoneda más grande después de Bitcoin, los pares comerciales de ETH se listan en casi todos los principales exchanges de criptomonedas. Algunos de los mercados más grandes incluyen:\n" +
                    "\n" +
                    "Binance\n" +
                    "Coinbase Pro\n" +
                    "OKEx\n" +
                    "Kraken\n" +
                    "Huobi Global");
        } else if (nameCrypto.equals("EOS")){
            name.setText("EOS / Eosio");
            icon.setBackgroundResource(R.drawable.eos);
            jsonRequest(8);
            description.setText("¿Qué es EOS?\n" +
                    "EOS es una plataforma diseñada para permitir a los desarrolladores crear aplicaciones descentralizadas (también conocidas como DApps).\n" +
                    "\n" +
                    "El objetivo del proyecto es relativamente sencillo: hacer que los programadores adopten la tecnología blockchain de la manera más simple posible y hagan que la red sea más fácil de usar que su competencia. Como resultado, se proporcionan herramientas y varios recursos educativos para apoyar a los desarrolladores que desean crear aplicaciones funcionales rápidamente.\n" +
                    "\n" +
                    "Otras prioridades incluyen ofrecer mayores niveles de escalabilidad que otras blockchains, algunas de las cuales solo pueden manejar menos de una docena de transacciones por segundo.\n" +
                    "\n" +
                    "EOS también tiene como objetivo mejorar la experiencia de los usuarios y las empresas. Mientras que el proyecto intenta ofrecer mayor seguridad y menos fricción a los consumidores, también compite por implementar flexibilidad y cumplimiento para las empresas.\n" +
                    "\n" +
                    "La blockchain se lanzó en junio de 2018.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de EOS?\n" +
                    "La plataforma EOS fue desarrollada por la empresa Block.one, y su whitepaper fue escrito por Daniel Larimer y Brendan Blumer.\n" +
                    "\n" +
                    "Ambos individuos siguen siendo miembros de Block.one y su equipo ejecutivo, con Blumer como CEO y Daniel Larimer como CTO.\n" +
                    "\n" +
                    "Blumer es un emprendedor en serie, y uno de sus primeros negocios fue la venta de activos virtuales para videojuegos. Continuó luego como cofundador de Okay.com, una agencia inmobiliaria centrada digitalmente en Hong Kong.\n" +
                    "\n" +
                    "Larimer es un programador de software que también ha iniciado varias empresas de criptomonedas. Estas incluyen la plataforma de trading de criptomonedas BitShares y la blockchain Steem.\n" +
                    "\n" +
                    "El par se reunió en 2016 y formó Block.one al año siguiente.\n" +
                    "\n" +
                    "¿Qué hace que EOS sea único?\n" +
                    "En cierta medida, podríamos argumentar que EOS tiene como objetivo crear familiaridad para sus usuarios. Mientras que EOS.IO es probablemente mejor comparado con un sistema operativo como Windows o iOS, EOS es la criptomoneda que impulsa la red.\n" +
                    "\n" +
                    "Según la empresa, tiene la capacidad de adaptarse a las demandas de cientos, hasta miles, de DApps, incluso si estuvieran siendo utilizadas por un considerable número de personas. Se dice que la ejecución paralela y un enfoque modular, impulsan esta eficiencia.\n" +
                    "\n" +
                    "En un giro único, los tenedores de tokens tienen la capacidad de votar a los productores de bloques, así como a otros asuntos como las actualizaciones de protocolos.\n" +
                    "\n" +
                    "Desafortunadamente, algunas de las características más distintivas de EOS son las que menos gustan a ciertos críticos. Hay quienes sostienen que la extensa participación de Block.one en este proyecto significa que está bastante centralizado, y algunos argumentan que esto es lo contrario de lo que se suponía que debían lograr las cadenas de bloques y las criptomonedas.\n" +
                    "\n" +
                    "¿Cuántas monedas de EOS hay en circulación?\n" +
                    "Hay 936 millones de monedas de EOS en circulación, al cierre de esta edición, y un suministro total de 1,02 mil millones de tokens.\n" +
                    "\n" +
                    "Block.one realizó una oferta inicial de monedas para EOS en junio de 2017 y duró un año, este tiempo es sustancialmente más largo que el que tuvieron muchas de otras ICO en ese momento.\n" +
                    "\n" +
                    "Se recaudó un total de USD 4,02 mil millones en el proceso, y los inversores de Estados Unidos no pudieron participar. Al analizar el detalle de cómo se distribuyeron los tokens, el 10% se asignó a los fundadores, mientras que el 90% se distribuyó entre los inversores.\n" +
                    "\n" +
                    "Cabe señalar que Block.one no recibirá esta asignación de inmediato, sino que lo hará en un período de 10 años.\n" +
                    "\n" +
                    "¿Cómo se asegura la red EOS?\n" +
                    "EOS utiliza un mecanismo de consenso de proof-of-stake delegado. Este concepto fue concebido por Larimer, y pretende resolver algunos de los defectos que se ven en los sistemas PoW y PoS.\n" +
                    "\n" +
                    "Como explicamos brevemente antes, los propietarios de tokens EOS pueden votar por representantes que se encargarán de validar las transacciones. Una de las ventajas es que esto ayuda a eliminar la consolidación, en la que los mineros más pequeños son relegados por aquellos que tienen mayores niveles de potencia y recursos informáticos.\n" +
                    "\n" +
                    "¿Dónde se puede comprar EOS?\n" +
                    "EOS está disponible a través de Binance, Coinbase, Kraken y muchos otros exchanges.");
        } else if (nameCrypto.equals("RUNE")){
            name.setText("RUNE / THORChain");
            icon.setBackgroundResource(R.drawable.rune);
            jsonRequest(9);
            description.setText("¿Qué es THORChain (RUNE)?\n" +
                    "THORCHain es un protocolo de liquidez descentralizado que permite a los usuarios intercambiar fácilmente activos de criptomonedas en una variedad de redes sin perder toda la custodia de sus activos en el proceso.\n" +
                    "\n" +
                    "Con THORChain, los usuarios pueden simplemente intercambiar un activo por otro en un entorno sin permiso, sin necesidad de depender de los libros de pedidos para obtener liquidez. En su lugar, los precios de mercado se mantienen a través de la proporción de activos en un conjunto (ver creador de mercados automatizado)).\n" +
                    "\n" +
                    "El token de utilidad nativo de la plataforma THORChain es RUNE. Se utiliza como moneda base en el ecosistema de THORChain y también se utiliza para la gobernanza y la seguridad de la plataforma como parte de los mecanismos de resistencia Sybil de THORChain, ya que los nodos de THORChain deben comprometer un mínimo de 1 millones de RUNE para participar en su proceso de consenso rotativo.\n" +
                    "\n" +
                    "THORChain fue financiado a través de una oferta inicial de DEX (IDO) que se lanzó a través del DEX de Binance en julio de 2019. Su red central se lanzó originalmente en enero de 2021, pero una actualización de múltiples cadenas está actualmente programada para 2021.\n" +
                    "\n" +
                    "¿Quiénes son los fundadores de THORChain?\n" +
                    "Según un representante oficial de THORChain, la plataforma no tiene CEO, fundador ni director. En su lugar, el desarrollo de la plataforma se organiza a través de Gitlab.\n" +
                    "\n" +
                    "Además de esto, quienes trabajan actualmente en el proyecto son en gran parte anónimos. Una vez más, un representante oficial de THORChain afirma que esto es para \"proteger el proyecto y garantizar que se pueda descentralizar\".\n" +
                    "\n" +
                    "Un tweet del proyecto arroja algo de luz sobre la teoría detrás de mantener un proyecto con un equipo anónimo, como se cita a continuación:\n" +
                    "\n" +
                    "\"-> Los desarrolladores trabajan para los nodos mediante un código de envío que hace que el sistema sea más valioso.\n" +
                    "\n" +
                    "-> Los nodos funcionan para los Stakers, ya que protegen los activos y están en línea.\n" +
                    "\n" +
                    "-> Los Stakers traen capital, colocados en el mercado para los Swappers.\n" +
                    "\n" +
                    "-> Los swappers pagan comisiones, aportando actividad económica\".\n" +
                    "\n" +
                    "¿Qué hace que THORChain sea único?\n" +
                    "THORChain utiliza un sistema único para ayudar a mitigar el problema de las \"pérdidas impermanentes\", o las pérdidas a menudo temporales que un proveedor de liquidez puede experimentar cuando contribuye a los fondos de liquidez. Lo logra mediante el uso de una tarifa basada en slip para ayudar a garantizar que la liquidez permanezca donde se necesita.\n" +
                    "\n" +
                    "Además de esto, THORChain combina una gama de tecnologías novedosas, que incluyen conexiones de estado en camino, una máquina de estado, el módulo de firma Bifröst y un protocolo TSS para facilitar sin problemas los intercambios de token entre cadenas. Todo esto se mantiene detrás de escena, haciendo que la plataforma sea accesible incluso para los comerciantes inexpertos.\n" +
                    "\n" +
                    "La plataforma no está orientada a las ganancias. Todas las tarifas generadas por el protocolo van directamente a los usuarios, y no hay disposiciones para el equipo. En cambio, el equipo se ve incentivado simplemente sosteniendo RUNE, como todos los demás.\n" +
                    "\n" +
                    "El token RUNE está disponible actualmente en múltiples blockchains, incluida Binance Chain (como token BEP-2) y Ethereum (como token ERC-20).\n" +
                    "\n" +
                    "¿Cuántas monedas THORChain (RUNE) hay en circulación?\n" +
                    "A partir de febrero de 2021, existen 158,4 millones de RUNE en circulación de un suministro total de 500 millones.\n" +
                    "\n" +
                    "Como mencionamos anteriormente, THORChain se lanzó inicialmente después de un IEO en Binance DEX. Como parte del IEO, se vendieron 20 millones de RUNE. Antes de esto, se vendieron un total de 130 millones de RUNE en rondas de financiación previas.\n" +
                    "\n" +
                    "De acuerdo con la propuesta oficial de Binance DEX, el 10% del suministro total (50 millones de tokens) se asignó al equipo y se bloqueó hasta el lanzamiento de la red principal, desbloqueándose al 20% por mes a partir de entonces.\n" +
                    "\n" +
                    "THORChain tiene actualmente una curva de emisión que empieza a partir del 30% APR. Esto está programado para alcanzar alrededor del 2% de la tasa de interés anual (APR) después de diez años.\n" +
                    "\n" +
                    "¿Cómo se protege la red THORChain?\n" +
                    "THORChain se elabora usando el Cosmos SDK y se basa en el mecanismo de consenso de Tendermint. Esto mantiene la red a salvo de ataques a través de un novedoso sistema BFT de prueba de participación (PoS) que permite que un gran número de validadores trabajen juntos para proponer y finalizar bloques de transacciones.\n" +
                    "\n" +
                    "Más allá de esto, los contratos inteligentes de THORChain han sido auditados por varias firmas de seguridad de terceros, incluida una de Certik, que no encontró vulnerabilidades.\n" +
                    "\n" +
                    "¿Dónde puedes comprar THORChain (RUNE)?\n" +
                    "RUNE es una criptomoneda popular que está disponible para comprar y comerciar en una gran cantidad de plataformas de intercambio centralizadas y descentralizadas. Los más destacados son Binance (centralizado) y SushiSwap (descentralizado).");
        }

    }

    private void jsonRequest(int index){

        String coinsAPI[] = {
                "https://api.coingecko.com/api/v3/simple/price?ids=binancecoin&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=stellar&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=avalanche-2&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=cosmos&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=cardano&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=tezos&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=eos&vs_currencies=usd",
                "https://api.coingecko.com/api/v3/simple/price?ids=thorchain&vs_currencies=usd"};
        String jsonName[] = {"binancecoin","stellar","avalanche-2","cosmos","cardano","tezos","bitcoin","ethereum","eos","thorchain"};

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, coinsAPI[index], null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.getString(""+jsonName[index]));
                    String pricecoin = jsonObject.getString("usd");
                    price.setText("Precio: " + pricecoin);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueue.add(jsonObjectRequest);
    }
}