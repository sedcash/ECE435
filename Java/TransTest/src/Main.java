import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.IOException;

public class Main {
    public static SynthesiserV2 synthesiser = new SynthesiserV2("AIzaSyBOti4mM-6x9WDnZIjIeyEU210pBXqWBgw");
    public static void main(String[] args) {
	String start, translated = null;
	start = "The cat (Felis catus) is a small carnivorous mammal.It is the only domesticated species in the family Felidae " +
            "and often referred to as the domestic cat to distinguish it from wild members of the family." +
            "The cat is either a house cat, kept as a pet, or a feral cat, freely ranging and avoiding human contact." +
            "A house cat is valued by humans for companionship and for its ability to hunt rodents. About 60 cat breeds " +
            "are recognized by various cat registries.";
	String[] sentence = start.split("\\.");
	System.out.println(sentence[1]);
	Translator translator = new Translator();

            for(int i = 0; i < sentence.length; i++){

                try {
                    translated += " " + translator.translate("es", sentence[i]);
                    System.out.println("hi");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            System.out.print(translated);
    }

    public  static void getLangaues(){
        String[] chars = {"ko",
                "ru",
                "zh",
                "hu",
                "th",
                "nb", "da", "tr", "et", "bs", "sw", "pt", "vi", "sv", "su", "bn", "el", "hi", "fi", "km", "bn", "fr", "uk", "en", "nl", "fr", "sr", "pt", "si", "de", "ku", "cs", "pl", "sk", "it", "ne", "hr", "zh", "cy", "ja", "sq", "es", "jv", "la", "in_ID", "ro", "ca", "ta", "en"};
        String[][] languageSet = {{"a","Afar"}, {"ab","Abkhazian"},{"ae","Avestan"},{"af","Afrikaans"},
                {"ak","Akan"},{"am","Amharic"},{"an","Aragonese"},{"ar","Arabic"},{"as","Assamese"},
                {"av","Avaric"},{"ay","Aymara"},{"az","Azerbaijani"},{"ba","Bashkir"},{"be","Belarusian"},
                {"bg","Bulgarian"},{"bh","Bihari languages"},{"bi","Bislama"},{"bm","Bambara"},{"bn","Bengali"},
                {"bo","Tibetan"},{"br","Breton"},{"bs","Bosnian"},{"ca","Catalan; Valencian"},
                {"ce","Chechen"},{"ch","Chamorro"},{"co","Corsican"},{"cr","Cree"},{"cs","Czech"},
                {"cu","Church Slavic; Old Slavonic; Church Slavonic; Old Bulgarian; Old Church Slavonic"},
                {"cv","Chuvash"},{"cy","Welsh"},{"da","Danish"},{"de","German"},{"dv","Divehi; Dhivehi; Maldivian"},
                {"dz","Dzongkha"},{"ee","Ewe"},{"el","Greek, Modern (1453-)"},{"en","English"},
                {"eo","Esperanto"},{"es","Spanish; Castilian"},{"et","Estonian"},{"eu","Basque"},
                {"fa","Persian"},{"ff","Fulah"},{"fi","Finnish"},{"fj","Fijian"},{"fo","Faroese"},
                {"fr","French"},{"fy","Western Frisian"},{"ga","Irish"},{"gd","Gaelic; Scottish Gaelic"},
                {"gl","Galician"},{"gn","Guarani"},{"gu","Gujarati"},{"gv","Manx"},{"ha","Hausa"},
                {"he","Hebrew"},{"hi","Hindi"},{"ho","Hiri Motu"},{"hr","Croatian"},
                {"ht","Haitian; Haitian Creole"},{"hu","Hungarian"},{"hy","Armenian"},{"hz","Herero"},
                {"ia","Interlingua (International Auxiliary Language Association)"},
                {"id","Indonesian"},{"ie","Interlingue; Occidental"},{"ig","Igbo"},{"ii","Sichuan Yi; Nuosu"},
                {"ik","Inupiaq"},{"io","Ido"},{"is","Icelandic"},{"it","Italian"},{"iu","Inuktitut"},
                {"ja","Japanese"},{"jv","Javanese"},{"ka","Georgian"},{"kg","Kongo"},{"ki","Kikuyu; Gikuyu"},
                {"kj","Kuanyama; Kwanyama"},{"kk","Kazakh"},{"kl","Kalaallisut; Greenlandic"},
                {"km","Central Khmer"},{"kn","Kannada"},{"ko","Korean"},{"kr","Kanuri"},{"ks","Kashmiri"},
                {"ku","Kurdish"},{"kv","Komi"},{"kw","Cornish"},{"ky","Kirghiz; Kyrgyz"},{"la","Latin"},
                {"lb","Luxembourgish; Letzeburgesch"},{"lg","Ganda"},{"li","Limburgan; Limburger; Limburgish"},
                {"ln","Lingala"},{"lo","Lao"},{"lt","Lithuanian"},{"lu","Luba-Katanga"},{"lv","Latvian"},
                {"mg","Malagasy"},{"mh","Marshallese"},{"mi","Maori"},{"mk","Macedonian"},
                {"ml","Malayalam"},{"mn","Mongolian"},{"mr","Marathi"},{"ms","Malay"},{"mt","Maltese"},
                {"my","Burmese"},{"na","Nauru"},{"nb","BokmÃ¥l, Norwegian; Norwegian BokmÃ¥l"},
                {"nd","Ndebele, North; North Ndebele"},{"ne","Nepali"},{"ng","Ndonga"},
                {"nl","Dutch; Flemish"},{"nn","Norwegian Nynorsk; Nynorsk, Norwegian"},
                {"no","Norwegian"},{"nr","Ndebele"},{"nv","Navajo; Navaho"},
                {"ny","Chichewa; Chewa; Nyanja"},{"oc","Occitan (post 1500); ProvenÃ§al"},{"oj","Ojibwa"},
                {"om","Oromo"},{"or","Oriya"},{"os","Ossetian; Ossetic"},{"pa","Panjabi; Punjabi"},
                {"pi","Pali"},{"pl","Polish"},{"ps","Pushto; Pashto"},{"pt","Portuguese"},{"qu","Quechua"},
                {"rm","Romansh"},{"rn","Rundi"},{"ro","Romanian; Moldavian; Moldovan"},{"ru","Russian"},
                {"rw","Kinyarwanda"},{"sa","Sanskrit"},{"sc","Sardinian"},{"sd","Sindhi"},
                {"se","Northern Sami"},{"sg","Sango"},{"si","Sinhala; Sinhalese"},{"sk","Slovak"},
                {"sl","Slovenian"},{"sm","Samoan"},{"sn","Shona"},{"so","Somali"},{"sq","Albanian"},
                {"sr","Serbian"},{"ss","Swati"},{"st","Sotho"},{"su","Sundanese"},{"sv","Swedish"},
                {"sw","Swahili"},{"ta","Tamil"},{"te","Telugu"},{"tg","Tajik"},{"th","Thai"},{"ti","Tigrinya"},
                {"tk","Turkmen"},{"tl","Tagalog"},{"tn","Tswana"},{"to","Tonga (Tonga Islands)"},
                {"tr","Turkish"},{"ts","Tsonga"},{"tt","Tatar"},{"tw","Twi"},{"ty","Tahitian"},
                {"ug","Uighur; Uyghur"},{"uk","Ukrainian"},{"ur","Urdu"},{"uz","Uzbek"},{"ve","Venda"},
                {"vi","Vietnamese"},{"vo","VolapÃ¼k"},{"wa","Walloon"},{"wo","Wolof"},{"xh","Xhosa"},
                {"yi","Yiddish"},{"yo","Yoruba"},{"za","Zhuang; Chuang"},{"zh","Chinese"}, {"zu","Zulu"}};
        System.out.println("{");
        for(int i = 0; i < chars.length; i++){
            for(int j = 0; j < languageSet.length; j++){
                if(chars[i] == languageSet[j][0]){
                    System.out.print("{\"" + chars[i] + "\", " + "\"" + languageSet[j][1] + "\"},");
                }
            }
        }
        System.out.println("};");
    }



}
