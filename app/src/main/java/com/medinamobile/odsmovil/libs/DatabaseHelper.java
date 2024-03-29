package com.medinamobile.odsmovil.libs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.medinamobile.odsmovil.entities.ODS;

import java.util.ArrayList;

/**
 * Created by Supertel on 27/12/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String COLUMN_NUMBER = "NUMBER";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_SHORTNAME = "SHORTNAME";
    public static final String COLUMN_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_QUESTIONS_TOTAL = "QUESTIONS_TOTAL";
    public static final String COLUMN_QUESTIONS_ANSWERED = "QUESTIONS_ANSWERED";
    public static final String COLUMN_PROGRESS = "PROGRESS";
    public static final String COLUMN_STATUS = "STATUS";
    private static final int DBVERSION = 1;
    private static final String DBNAME = "ods.db";
    private static DatabaseHelper mInstance;

    public DatabaseHelper(Context context,
                          String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context){
        super(context, DBNAME, null, DBVERSION);
    }

    public static DatabaseHelper getInstance(Context context) {
        if (mInstance==null){
            mInstance = new DatabaseHelper(context);
        }
        return mInstance;
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ODS ("+COLUMN_NUMBER+" INT PRIMARY KEY, " +
                COLUMN_NAME + "STRING, "+COLUMN_SHORTNAME+" STRING, "+COLUMN_DESCRIPTION+" TEXT, "+
                COLUMN_QUESTIONS_TOTAL+" INT, "+COLUMN_QUESTIONS_ANSWERED+" INT, "+COLUMN_PROGRESS+" INT, "+COLUMN_STATUS+" INT)");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (1, 'Poner fin a la pobreza en todas sus formas en todo el mundo', 'Fin de la Pobreza', 'Los índices de pobreza extrema se han reducido a la mitad desde 1990. Si bien se trata de un logro notable, 1 de cada 5 personas de las regiones en desarrollo aún vive con menos de 1,25 dólares al día, y hay muchos más millones de personas que ganan poco más de esa cantidad diaria, a lo que se añade que hay muchas personas en riesgo de recaer en la pobreza.                La pobreza va más allá de la falta de ingresos y recursos para garantizar unos medios de vida sostenibles. Entre sus manifestaciones se incluyen el hambre y la malnutrición, el acceso limitado a la educación y a otros servicios básicos, la discriminación y la exclusión sociales y la falta de participación en la adopción de decisiones. El crecimiento económico debe ser inclusivo con el fin de crear empleos sostenibles y promover la igualdad.',17,0,0,1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (2, 'Poner fin al hambre, lograr la seguridad alimentaria y la mejora de la nutrición y promover la agricultura sostenible', 'Hambre Cero', 'Si se hace bien, la agricultura, la silvicultura y las piscifactorías pueden suministrarnos comida nutritiva para todos y generar ingresos decentes, mientras se apoya el desarrollo de las gentes del campo y la protección del medio ambiente. Pero ahora mismo, nuestros suelos, agua, océanos, bosques y nuestra biodiversidad están siendo rápidamente degradados. El cambio climático está poniendo mayor presión sobre los recursos de los que dependemos y aumentan los riesgos asociados a desastres tales como sequías e inundaciones. Muchas campesinas y campesinos ya no pueden ganarse la vida en sus tierras, lo que les obliga a emigrar a las ciudades en busca de oportunidades. Necesitamos una profunda reforma del sistema mundial de agricultura y alimentación si queremos nutrir a los 925 millones de hambrientos que existen actualmente y los dos mil millones adicionales de personas que vivirán en el año 2050. El sector alimentario y el sector agrícola ofrecen soluciones claves para el desarrollo y son vitales para la eliminación del hambre y la pobreza.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (3, 'Garantizar una vida sana y promover el bienestar para todos en todas las edades', 'Salud y Bienestar', 'Para lograr el desarrollo sostenible es fundamental garantizar una vida saludable y promover el bienestar para todos a cualquier edad. Se han obtenido grandes progresos en relación con el aumento de la esperanza de vida y la reducción de algunas de las causas de muerte más comunes relacionadas con la mortalidad infantil y materna. Se han logrado grandes avances en cuanto al aumento del acceso al agua limpia y el saneamiento, la reducción de la malaria, la tuberculosis, la poliomielitis y la propagación del VIH/SIDA. Sin embargo, se necesitan muchas más iniciativas para erradicar por completo una amplia gama de enfermedades y hacer frente a numerosas y variadas cuestiones persistentes y emergentes relativas a la salud.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (4, 'Garantizar una educación inclusiva, equitativa y de calidad y promover oportunidades de aprendizaje durante toda la vida para todos', 'Educación de Calidad', 'La consecución de una educación de calidad es la base para mejorar la vida de las personas y el desarrollo sostenible. Se han producido importantes avances con relación a la mejora en el acceso a la educación a todos los niveles y el incremento en las tasas de escolarización en las escuelas, sobre todo en el caso de las mujeres y las niñas. Se ha incrementado en gran medida el nivel mínimo de alfabetización, si bien es necesario redoblar los esfuerzos para conseguir mayores avances en la consecución de los objetivos de la educación universal. Por ejemplo, se ha conseguido la igualdad entre niñas y niños en la educación primaria en el mundo, pero pocos países han conseguido ese objetivo a todos los niveles educativos.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (5, 'Lograr la igualdad entre los géneros y empoderar a todas las mujeres y las niñas', 'Igualdad de Género', 'Si bien se han producido avances a nivel mundial con relación a la igualdad entre los géneros a través de los Objetivos de Desarrollo del Milenio (incluida la igualdad de acceso entre niñas y niños a la enseñanza primaria), las mujeres y las niñas siguen sufriendo discriminación y violencia en todos los lugares del mundo. La igualdad entre los géneros no es solo un derecho humano fundamental, sino la base necesaria para conseguir un mundo pacífico, próspero y sostenible. Si se facilita a las mujeres y niñas igualdad en el acceso a la educación, atención médica, un trabajo decente y representación en los procesos de adopción de decisiones políticas y económicas, se impulsarán las economías sostenibles y se beneficiará a las sociedades y a la humanidad en su conjunto.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (6, 'Garantizar la disponibilidad de agua y su gestión sostenible y el saneamiento para todos', 'Agua Limpia y Saneamiento', 'El agua libre de impurezas y accesible para todos es parte esencial del mundo en que queremos vivir. Hay suficiente agua dulce en el planeta para lograr este sueño.  La escasez de recursos hídricos, la mala calidad del agua y el saneamiento inadecuado influyen negativamente en la seguridad alimentaria , las opciones de medios de subsistencia y las oportunidades de educación para las familias pobres en todo el mundo. La sequía afecta a algunos de los países más pobres del mundo, recrudece el hambre y la desnutrición. Para 2050, al menos una de cada cuatro personas probablemente viva en un país afectado por escasez crónica y reiterada de agua dulce.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (7, 'Garantizar el acceso a una energía asequible, segura, sostenible y moderna para todos', 'Energía Asequible y No Contaminante', 'La energía es central para casi todos los grandes desafíos y oportunidades a los que hace frente el mundo actualmente. Ya sea para los empleos, la seguridad, el cambio climático, la producción de alimentos o para aumentar los ingresos, el acceso a la energía para todos es esencial. La energía sostenible es una oportunidad – que transforma vidas, economías y el planeta. El Secretario General de las Naciones Unidas Ban Ki-moon está a la cabeza de la iniciativa Energía sostenible para todos para asegurar el acceso universal a los servicios de energía modernos, mejorar el rendimiento y aumentar el uso de fuentes renovables.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (8, 'Promover el crecimiento económico sostenido, inclusivo y sostenible, el empleo pleno y productivo y el trabajo decente para todos', 'Trabajo Decente y Crecimiento Económico', 'Aproximadamente la mitad de la población mundial todavía vive con el equivalente a unos 2 dólares de los Estados Unidos diarios, y en muchos lugares el hecho de tener un empleo no garantiza la capacidad para escapar de la pobreza. Debemos reflexionar sobre este progreso lento y desigual, y revisar nuestras políticas económicas y sociales destinadas a erradicar la pobreza. La continua falta de oportunidades de trabajo decente, la insuficiente inversión y el bajo consumo producen una erosión del contrato social básico subyacente en las sociedades democráticas: el derecho de todos a compartir el progreso. La creación de empleos de calidad seguirá constituyendo un gran desafío para casi todas las economías más allá de 2015. Para conseguir el desarrollo económico sostenible, las sociedades deberán crear las condiciones necesarias para que las personas accedan a empleos de calidad, estimulando la economía sin dañar el medio ambiente. También tendrá que haber oportunidades laborales para toda la población en edad de trabajar, con condiciones de trabajo decentes.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (9, 'Construir infraestructuras resilientes, promover la industrialización inclusiva y sostenible y fomentar la innovación', 'Industria, Innovación e Infraestructura', 'Las inversiones en infraestructura (transporte, riego, energía y tecnología de la información y las comunicaciones) son fundamentales para lograr el desarrollo sostenible y empoderar a las comunidades en numerosos países. Desde hace tiempo se reconoce que, para conseguir un incremento de la productividad y de los ingresos y mejoras en los resultados sanitarios y educativos, se necesitan inversiones en infraestructura. El ritmo de crecimiento y urbanización también está generando la necesidad de contar con nuevas inversiones en infraestructuras sostenibles que permitirán a las ciudades ser más resistentes al cambio climático e impulsar el crecimiento económico y la estabilidad social. Además de la financiación gubernamental y la asistencia oficial para el desarrollo, se está promoviendo la financiación del sector privado para los países que necesitan apoyo financiero, tecnológico y técnico.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (10, 'Reducir la desigualdad en y entre los países', 'Reducción de las Desigualdades', 'La comunidad internacional ha logrado grandes avances sacando a las personas de la pobreza. Las naciones más vulnerables –los países menos adelantados, los países en desarrollo sin litoral y los pequeños Estados insulares en desarrollo– continúan avanzando en el ámbito de la reducción de la pobreza. Sin embargo, siguen existiendo desigualdades y grandes disparidades en el acceso a los servicios sanitarios y educativos y a otros bienes productivos. Además, a pesar de que la desigualdad de los ingresos entre países ha podido reducirse, dentro de los propios países ha aumentado la desigualdad. Existe un consenso cada vez mayor de que el crecimiento económico no es suficiente para reducir la pobreza si este no es inclusivo ni tiene en cuenta las tres dimensiones del desarrollo sostenible: económica, social y ambiental. Con el fin de reducir la desigualdad, se ha recomendado la aplicación de políticas universales que presten también especial atención a las necesidades de las poblaciones desfavorecidas y marginadas.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (11, 'Lograr que las ciudades y los asentamientos humanos sean inclusivos, seguros, resilientes y sostenibles', 'Ciudades y Comunidades Sostenibles', 'Las ciudades son hervideros de ideas, comercio, cultura, ciencia, productividad, desarrollo social y mucho más. En el mejor de los casos, las ciudades han permitido a las personas progresar social y económicamente. Ahora bien, son muchos los problemas que existen para mantener ciudades de manera que se sigan creando empleos y prosperidad sin ejercer presión sobre la tierra y los recursos. Los problemas comunes de las ciudades son la congestión, la falta de fondos para prestar servicios básicos, la escasez de vivienda adecuada y el deterioro de la infraestructura. Los problemas que enfrentan las ciudades se pueden vencer de manera que les permita seguir prosperando y creciendo, y al mismo tiempo aprovechar mejor los recursos y reducir la contaminación y la pobreza. El futuro que queremos incluye a ciudades de oportunidades, con acceso a servicios básicos, energía, vivienda, transporte y más facilidades para todos.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (12, 'Garantizar modalidades de consumo y producción sostenibles', 'Producción y Consumo Responsables', 'El consumo y la producción sostenibles consisten en fomentar el uso eficiente de los recursos y la eficiencia energética, infraestructuras sostenibles y facilitar el acceso a los servicios básicos, empleos ecológicos y decentes, y una mejor calidad de vida para todos. Su aplicación ayuda a lograr los planes generales de desarrollo, reducir los futuros costos económicos, ambientales y sociales, aumentar la competitividad económica y reducir la pobreza. El objetivo del consumo y la producción sostenibles es hacer más y mejores cosas con menos recursos, incrementando las ganancias netas de bienestar de las actividades económicas mediante la reducción de la utilización de los recursos, la degradación y la contaminación durante todo el ciclo de vida, logrando al mismo tiempo una mejor calidad de vida. En ese proceso participan distintos interesados, entre ellos empresas, consumidores, encargados de la formulación de políticas, investigadores, científicos, minoristas, medios de comunicación y organismos de cooperación para el desarrollo. También es necesario adoptar un enfoque sistémico y lograr la cooperación entre los participantes de la cadena de suministro, desde el productor hasta el consumidor final. Consiste en involucrar a los consumidores mediante la sensibilización y la educación sobre el consumo y los modos de vida sostenibles, facilitándoles información adecuada a través de normas y etiquetas, y participando en la contratación pública sostenible, entre otros.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (13, 'Adoptar medidas urgentes para combatir el cambio climático y sus efectos', 'Acción por el Clima', 'El cambio climático afecta a todos los países en todos los continentes. Tiene un impacto negativo en la economía nacional y en la vida de las personas, de las comunidades y de los países. En un futuro las consecuencias serán todavía peores. Las personas viven en su propia piel las consecuencias del cambio climático, que incluyen cambios en los patrones climáticos, el aumento del nivel del mar y los fenómenos meteorológicos más extremos. Las emisiones de gases de efecto invernadero causadas por las actividades humanas hacen que esta amenaza aumente. De hecho, las emisiones nunca habían sido tan altas. Si no actuamos, la temperatura media de la superficie del mundo podría aumentar unos 3 grados centígrados este siglo y en algunas zonas del planeta podría ser todavía peor. Las personas más pobres y vulnerables serán los más perjudicados. Tenemos a nuestro alcance soluciones viables para que los países puedan tener una actividad económica más sostenible y más respetuosa con el medio ambiente. El cambio de actitudes se acelera a medida que más personas están recurriendo a la energía renovable y a otras soluciones para reducir las emisiones. Pero el cambio climático es un reto global que no respeta las fronteras nacionales. Las emisiones en un punto del planeta afectan a otros lugares lejanos. Es un problema que requiere que la comunidad internacional trabaje de forma coordinada y precisa de la cooperación internacional para que los países en desarrollo avancen hacia una economía baja en carbono. Los países están trabajando para adoptar un acuerdo global en París este mes de diciembre con el objetivo de luchar contra el cambio climático.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (14, 'Conservar y utilizar en forma sostenible los océanos, los mares y los recursos marinos para el desarrollo sostenible', 'Vida Submarina', 'Los océanos del mundo – su temperatura, química, corrientes y vida – mueven sistemas mundiales que hacen que la Tierra sea habitable para la humanidad. Nuestras precipitaciones, el agua potable, el clima, el tiempo, las costas, gran parte de nuestros alimentos e incluso el oxígeno del aire que respiramos provienen, en última instancia del mar y son regulados por este. Históricamente, los océanos y los mares han sido cauces vitales del comercio y el transporte. La gestión prudente de este recurso mundial esencial es una característica clave del futuro sostenible.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (15, 'Promover el uso sostenible de los ecosistemas terrestres, luchar contra la desertificación, detener e invertir la degradación de las tierras y frenar la pérdida de la diversidad biológica', 'Vida de Ecosistemas Terrestres', 'El 30% de la superficie terrestre está cubierta por bosques y estos, además de proporcionar seguridad alimentaria y refugio, son fundamentales para combatir el cambio climático, pues protegen la diversidad biológica y las viviendas de la población indígena. Cada año desaparecen 13 millones de hectáreas de bosque y la degradación persistente de las zonas áridas ha provocado la desertificación de 3.600 millones de hectáreas. La deforestación y la desertificación –provocadas por las actividades humanas y el cambio climático– suponen grandes retos para el desarrollo sostenible y han afectado a las vidas y los medios de vida de millones de personas en la lucha contra la pobreza. Se están poniendo en marcha medidas destinadas a la gestión forestal y la lucha contra la desertificación.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (16, 'Promover sociedades pacíficas e inclusivas para el desarrollo sostenible, facilitar el acceso a la justicia para todos y crear instituciones eficaces, responsables e inclusivas a todos los niveles', 'Paz, Justicia e Instituciones Sólidas', 'El objetivo 16 de los Objetivos de Desarrollo Sostenible propuestos se centra en la promoción de sociedades pacíficas e inclusivas para el desarrollo sostenible, la provisión de acceso a la justicia para todos y la construcción de instituciones responsables y eficaces a todos los niveles.',17,0,0,-1);");
        sqLiteDatabase.execSQL("INSERT INTO ODS VALUES (17, 'Fortalecer los medios de ejecución y revitalizar la Alianza Mundial para el Desarrollo Sostenible', 'Alianzas para lograr los Objetivos', 'Para que una agenda de desarrollo sostenible sea eficaz se necesitan alianzas entre los gobiernos, el sector privado y la sociedad civil. Estas alianzas inclusivas se construyen sobre la base de principios y valores, una visión compartida y objetivos comunes que otorgan prioridad a las personas y al planeta, y son necesarias a nivel mundial, regional, nacional y local. Es preciso adoptar medidas urgentes encaminadas a movilizar, reorientar y aprovechar billones de dólares de recursos privados para generar transformaciones a fin de alcanzar los Objetivos de Desarrollo Sostenible. Se necesitan inversiones a largo plazo, por ejemplo la inversión extranjera directa, en sectores fundamentales, en particular en los países en desarrollo. Entre estos sectores figuran la energía sostenible, la infraestructura y el transporte, así como las tecnologías de la información y las comunicaciones. El sector público deberá establecer una orientación clara al respecto. Deben reformularse los marcos de examen y vigilancia, los reglamentos y las estructuras de incentivos que facilitan esas inversiones a fin de atraer inversiones y fortalecer el desarrollo sostenible. También deben fortalecerse los mecanismos nacionales de vigilancia, en particular las instituciones superiores de auditoría y la función de fiscalización que corresponde al poder legislativo.',17,0,0,-1);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public ArrayList<ODS> getAllOds(){
        ArrayList<ODS> list = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM ODS",null);
        if (cursor.getCount()>0){
            while (cursor.moveToNext()){
                ODS temp = new ODS(cursor);
                list.add(temp);
            }
        }
        cursor.close();
        db.close();
        return list;
    }

    public int getHighScoreForOds(int odsNumber) {
        int score = -1;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT "+COLUMN_QUESTIONS_ANSWERED+" FROM ODS WHERE "+COLUMN_NUMBER+"=?",new String[]{String.valueOf(odsNumber)});
        if (cursor.getCount()>0){
            cursor.moveToNext();
            score = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return score;
    }

    public boolean setNewHighScoreForOds(int odsNumber, int responseScore) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTIONS_ANSWERED, responseScore);
        int updated = db.update("ODS", values, COLUMN_NUMBER+"=?", new String[]{String.valueOf(odsNumber)});
        db.close();
        return updated==1;
    }
}
