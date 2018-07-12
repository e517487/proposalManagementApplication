package com.inetpsa.pct00.application.service;

import com.inetpsa.pct00.application.domain.Algemeen;
import com.inetpsa.pct00.application.domain.Record10AanvraagGegevensAlgemeen;
import com.inetpsa.pct00.application.domain.RekenmoduleAanvraag;
import com.inetpsa.pct00.application.domain.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Import PC-Finet datafile containing requests.
 * <p>
 * The file contains 0..n Requests.
 * <p>
 * Every request contains 1..n different records.
 * One record per line in the File.
 * So lets make a method for every record known.
 */
@Service
@Transactional
public class PcfinetImportService {

    private final Logger log = LoggerFactory.getLogger( PcfinetImportService.class );

    private static final int RECORD_LINE_LENGTH = 700;

    /**
     * Open file and retrieve the requests from the file.
     * <p>
     * read file flow: readline
     * check record 00 of 99
     * else
     *
     * @param fileName
     */
    public List<Request> importRequestsFromFile(String fileName) {
        List<Request> requestList = new ArrayList<>();
        List<RekenmoduleAanvraag> rekenmoduleAanvraagList = new ArrayList<>();
        StringBuilder recordLine = new StringBuilder();


        Collection<PcFinetLineData> pcFinetLines = new ArrayList<>();


        try (BufferedReader br = new BufferedReader( new FileReader( fileName ) )) {
            pcFinetLines = br.lines()
                .map( str -> new PcFinetLineData( str ) )
                .collect( Collectors.toList() );

            log.info( "read from file [" + fileName + "] nummer of lines: " + pcFinetLines.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // make new requests for every unique pcFinetNr.
        requestList = pcFinetLines.stream()
//            .distinct()
            .filter(PcFinetLineData.distinctByKey(p -> p.getPcFinetNr()))
            .map( p -> {
                Request request = new Request();
                request.setPcFinetNr( p.getPcFinetNr() );
                return request;
            } )
            .collect( Collectors.toList() );
        log.info( "nummer of unique requests: " + requestList.size());
        // check file name and open file.
        // Create a Request object for every single request in the file
        // read 1 line and check which record type it contain and call method.
        // add data to Request object

        return requestList;
    }



    /**
     *   ' Recordtype 1 : Start (
     * 'Private Type Record_Start
     * '  PCFinetnr    As String * 11
     * '  RecordType   As String * 2
     * '  Volgnr       As String * 3
     * '  CreatieDatum As String * 8
     * '  CreatieTijd  As String * 5
     * '  FILLER       As String * 483 '<- in doc. stond 482, maar uit bestand blijkt 483 !
     * '  FILLER2     As String * 128
     * 'End Type
     */

    /**
     *   ' RecordType 99: Eindrecord
     * 'Private Type Record_Eind
     * '  PCFinetnr       As String * 11
     * '  RecordType      As String * 2
     * '  Volgnr          As String * 3
     * '  CreatieDatum    As String * 8
     * '  CreatieTijd     As String * 5
     * '  AantalAanvragen As String * 5
     * '  AantalRegels    As String * 5
     * '  FILLER          As String * 473 ' In doc. stond 472, uit bestand blijkt 473
     * '  FILLER2     As String * 128
     * 'End Type
     */

    /**
     *   ' Recordtype 10 : Aanvraaggegevens algemeen
     * Private Type Record_AV_ALG
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2    already stripped
     *   Volgnr            As String * 3    0..3
     *   DEALERNR          As String * 6    3..9
     *   PROD_CODE         As String * 5    9..14
     *   Zoeknaam          As String * 20   14..34
     *   Verkoper          As String * 30   34..64
     *   DealerTelnr       As String * 20   64..84
     *   Acceptatie        As String * 1    84..85
     *   Aanv_datum        As String * 8    85..93
     *   Aanv_tijd         As String * 5    93..98
     *   Acc_Datum         As String * 8    98..106
     *   Acc_tijd          As String * 5    106..111
     *   Prt_Datum         As String * 8    111..119
     *   Invoerder         As String * 7    119..126
     *   Acceptant         As String * 7    126..133
     *   FILLER            As String * 365
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */
    private void parseRecord10AanvraagGegevensAlgemeen( Request request, String recordData) {
        Record10AanvraagGegevensAlgemeen algemeen = new Record10AanvraagGegevensAlgemeen();

        algemeen.setVolgNr( Integer.parseInt( recordData.substring( 0, 3) ) );
        algemeen.setDealerNr( recordData.substring( 3, 9));
        algemeen.setProductCode( recordData.substring( 9, 14));
        algemeen.setZoeknaam( recordData.substring( 14, 34));
        algemeen.setVerkoper( recordData.substring( 34, 64));
        algemeen.setDealerTelnr( recordData.substring( 64, 84));
        algemeen.setAcceptatie( recordData.substring( 84, 85));
        algemeen.setAanvangDatum( LocalDate.parse( recordData.substring( 85, 93),   DateTimeFormatter.ofPattern("yyyyMMdd") ));
        algemeen.setAanvangTijd( ZonedDateTime.parse(recordData.substring( 93, 98),   DateTimeFormatter.ofPattern("uu:mm") ));
        algemeen.setAcceptatieDatum( LocalDate.parse( recordData.substring( 98, 106),   DateTimeFormatter.ofPattern("yyyyMMdd") ));
        algemeen.setAcceptatieTijd( ZonedDateTime.parse( recordData.substring( 106, 111) ,  DateTimeFormatter.ofPattern("uu:mm") ));
        algemeen.setPrtDatum( LocalDate.parse( recordData.substring( 111, 119),   DateTimeFormatter.ofPattern("yyyyMMdd") ));
        algemeen.setInvoerder( recordData.substring( 119, 126));
        algemeen.setAcceptant( recordData.substring( 126, 133));
        return;
    }

    /**
     *   ' Recordtype 11 : Aanvraaggegevens, opmerking
     * Private Type Record_AV_Opmerking
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Regel1            As String * 80
     *   Regel2            As String * 80
     *   Regel3            As String * 80
     *   Regel4            As String * 80
     *   Regel5            As String * 80
     *   Regel6            As String * 80
     *   FILLER            As String * 31 ' in doc stond 32?
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *    Recordtype 20 : Financieel
     * Private Type Record_Financieel
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   con_soort         As String * 2
     *   Ma_Optie          As String * 1 ' niet meer gebruikt in PCRT
     *   KM_Jaar           As String * 6 ' niet meer gebruikt in PCRT
     *   KM_Stand          As String * 6 ' niet meer gebruikt in PCRT
     *   Afg_kent          As String * 6
     *   Verkprijs         As String * 9
     *   Aanbetal          As String * 9
     *   Vergoeding        As String * 9
     *   herfin_bed        As String * 9
     *   hoofdsom          As String * 9 ' EH 27-5-2004
     *   fin_bedrag        As String * 9 ' EH 27-5-2004
     *   Restant           As String * 9 ' EH 27-5-2004
     *   Looptijd          As String * 2
     *   Termijn           As String * 9
     *   Interest          As String * 7
     *   Service           As String * 1
     *   GMINRUIL          As String * 9 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   FILLER            As String * 383
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 25 : Herfinanciering
     * Private Type Record_Herfin
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Srt_Finmij        As String * 1
     *   Finmij            As String * 30
     *   Bruto             As String * 9
     *   Stat_Datum        As String * 8
     *   Contractnr        As String * 20
     *   Bethist           As String * 1
     *   FILLER            As String * 426 ' in doc. stond 428
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 30 : Inruil
     * Private Type Record_Inruil
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Merk              As String * 15
     *   Type              As String * 6
     *   Model             As String * 20
     *   bouwjaar          As String * 4
     *   FILLER            As String * 451
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 35 : Object
     * Private Type Record_Object
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Merk              As String * 15
     *   Type              As String * 6
     *   Model             As String * 20
     *   Onderpand         As String * 30
     *   Categorie         As String * 1
     *   bouwjaar          As String * 4
     *   Kenteken          As String * 8
     *   Chassisnr         As String * 15
     *   Mfrt_merk         As String * 2
     *   Mfrt_Type         As String * 4
     *   MdlAggrnr         As String * 3
     *   FILLER            As String * 388
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 40 : Acceptatie / Score
     * Private Type Record_Score
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Tenaamstel        As String * 20
     *   Riskmodel         As String * 1
     *   MatigHist         As String * 1
     *   InTeleGids        As String * 1
     *   Interview         As String * 1
     *   Bekend            As String * 1
     *   Eerder            As String * 1
     *   Alias             As String * 1
     *   aCode             As String * 1
     *   APlusCode         As String * 1
     *   ACodeHyp          As String * 1
     *   Afgelost          As String * 1
     *   Lopend            As String * 1
     *   Lopend_sk         As String * 1
     *   Leg               As String * 1
     *   Afgewezen         As String * 1
     *   Score             As String * 4
     *   Klasse            As String * 1
     *   Auto_Acc          As String * 1
     *   Add_Info          As String * 1
     *   Afwijzen          As String * 1
     *   Log_Score         As String * 33
     *   Log_Info          As String * 24
     *   Log_Afwijs        As String * 4
     *   Zekerheden        As String * 5
     *   bkrscore          As String * 1 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2
     *   avstatus          As String * 2 ' 100713 PROOVIT-EH: Toevoeging ivm Basel 2
     *   AantInkomn        As String * 1 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTINKOMEN
     *   AantBkrCtr        As String * 2 ' 100907 PROOVIT-EH: Toevoeging ivm Basel 2 - AANTBKRCONTR
     *   FILLER            As String * 380 ' in doc. stond 380...
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 45 : Relatie
     * Private Type Record_Relatie
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Rol               As String * 2
     *   Titulatuur        As String * 2
     *   Voorletter        As String * 20
     *   prefix            As String * 20
     *   Naam              As String * 30
     *   Zoeknaam          As String * 20
     *   Straat            As String * 32
     *   HuisNr            As String * 5
     *   ToevhuisNr        As String * 7
     *   Postcode          As String * 6
     *   Plaats            As String * 32
     *   TelefoonNr        As String * 20
     *   gebdatum          As String * 8
     *   GebPlaats         As String * 32
     *   Nat               As String * 2
     *   Burgstatus        As String * 2
     *   geslacht          As String * 2
     *   Rekeningnr        As String * 20
     *   Bankgroep         As String * 2
     *   Rijbewijs         As String * 20
     *   Beroep            As String * 30
     *   Cat_Beroep        As String * 2
     *   Srt_Beroep        As String * 2
     *   Naam_Werk         As String * 30
     *   PltsWerk          As String * 30
     *   Tel_Werk          As String * 20
     *   StartWerk         As String * 8
     *   Cat_Ink           As String * 2
     *   Uitkering         As String * 2
     *   Kinderen          As String * 2
     *   Behuizing         As String * 2
     *   Woon_duur         As String * 2
     *   Woonlasten        As String * 8
     *   ' 100310 PROOVIT-EH: Basel II -- Nieuwe velden
     *   Ink_Neto          As String * 7 '  100310 PROOVIT-EH: Basel II -- NETTO
     *   InkTotNeto        As String * 7 '  100310 PROOVIT-EH: Basel II -- TOTAALNETTO
     *   OpbMndBdrg        As String * 7 '  100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG
     *   PercSchLst        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -SCHULDENLAST
     *   PercScLsTo        As String * 7 '  100310 PROOVIT-EH: Basel II -- PERC -TOT - SCHULDENLAST
     *   StartWonin        As String * 8 '  100907 PROOVIT-EH: Basel II -- StartWoning = datum
     *   FILLER            As String * 31 ' 120904 PROOVIT-EH: ALN-36 (MBe)
     *   IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MBe)
     *   BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MBe)
     *   EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MBe)
     *   '-- 141008 PROOVIT-EH: DESIN-292 - New fields
     *   NAT_CODE          As String * 3
     *   VERBLIJFNR        As String * 15
     *   EVOLGEZIN         As String * 1
     *   EVOLINKOMSTEN     As String * 1
     *   SOORTWRKCONTRAKT  As String * 1
     *   EINDDATWRKCONTR   As String * 6
     *   INTENTIEWRKCONTR  As String * 1
     *   VERZOEKPLATFORM   As String * 1
     *   '-- 141008 PROOVIT-EH: DESIN-292 - New fields END
     *   Filler3           As String * 31 ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 46 : Relatie - Huishoudelijk
     * Private Type Record_RelatieHuish ' 100310 PROOVIT-EH: New for Basel II
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   HuisHgld          As String * 7   ' 100310 PROOVIT-EH: Basel II -- HUISHGELD
     *   HuisHGlTot        As String * 7   ' 100310 PROOVIT-EH: Basel II -- TOTAALHUISHGELD
     *   OpnStdMndB        As String * 7   ' 100310 PROOVIT-EH: Basel II -- OPENST -MNDBEDRAG - HUISH
     *   VateLasten        As String * 7   ' 100310 PROOVIT-EH: Basel II -- VASTE -MNDLASTEN - HUISH
     *   TotMndLast        As String * 7   ' 100310 PROOVIT-EH: Basel II -- Totaal -MNDLASTEN - HUISH
     *   FILLER            As String * 460 ' 100310 PROOVIT-EH: Basel II -- in doc. stond 460
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */
    /**
     *   ' Recordtype 50 : Bedrijf
     * Private Type Record_Bedrijf
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Rol               As String * 2
     *   BedNaam           As String * 30
     *   Zoeknaam          As String * 20
     *   Rechtsvorm        As String * 2
     *   Straat            As String * 32
     *   HuisNr            As String * 5
     *   ToevhuisNr        As String * 7
     *   Postcode          As String * 6
     *   Plaats            As String * 32
     *   TelefoonNr        As String * 20
     *   OprDatum          As String * 8
     *   Gemachtigd        As String * 30
     *   Functiegem        As String * 20
     *   Rekeningnr        As String * 20
     *   Bankgroep         As String * 2
     *   Stat_naam         As String * 79
     *   KvK_Inschr        As String * 10
     *   KvK_Plaats        As String * 32
     *   Kapitaal          As String * 9
     *   DunBradnr         As String * 15
     *   JaarBalans        As String * 4
     *   FILLER            As String * 111 ' in doc. stond 110
     *   IBAN              As String * 34 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   BIC               As String * 12 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   EMAIL             As String * 80 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

    /**
     *   ' Recordtype 55 : Scoring
     * Private Type Record_Scoring ' 100310 PROOVIT-EH: New for Basel II
     *   PCFinetnr         As String * 11
     *   RecordType        As String * 2
     *   Volgnr            As String * 3
     *   Scoring25         As String * 450 ' 25 * 3 * 6  ' 100310 PROOVIT-EH: Basel II -- SCORING OCCURS max 25 blocks of 6x3
     *   FILLER            As String * 46  ' 100310 PROOVIT-EH: Basel II -- in doc. stond 46
     *   FILLER2           As String * 128 ' 120904 PROOVIT-EH: ALN-36 (MB)
     *   Filler3           As String * 60  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     * Private Type Record_ScoringTempRegel ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55
     *   Regel     As String * 18   ' 100310 PROOVIT-EH: Basel II -- REG -code
     * End Type
     * Private Type Record_ScoringSub1 ' 100310 PROOVIT-EH: New for Basel II - subrecord of 55
     *   REG_CODE          As String * 3   ' 100310 PROOVIT-EH: Basel II -- REG -code
     *   COND_NR           As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -NR
     *   Cond_Score        As String * 3   ' 100310 PROOVIT-EH: Basel II -- COND -Score
     *   AfwysRegCd        As String * 3   ' 100310 PROOVIT-EH: Basel II -- AFWIJS -REG - code
     *   ZekerhCode        As String * 3   ' 100310 PROOVIT-EH: Basel II -- ZEKERH -code
     *   InfoRegCod        As String * 3   ' 100310 PROOVIT-EH: Basel II -- INFO -REG - code
     * End Type
     */
    /**
     *   ' Recordtype 61, 62, 63 : Uitleg
     * Private Type Record_Uitleg ' 141008 PROOVIT-EH: DESIN-292 - New record, multi used by 61, 62, 63
     *     PCFinetnr         As String * 11
     *     RecordType        As String * 2
     *     Volgnr            As String * 3
     *     Rol               As String * 2
     *     UITLEGGEZIN       As String * 240
     *     UITLEGINKOMSTEN   As String * 240
     *     UITLEGINPLATFORM  As String * 200
     *     Filler3           As String * 2  ' 141008 PROOVIT-EH: DESIN-292
     * End Type
     */

}


/**
 * Helper class for reading all lines from file.
 * this to collect all
 * pcFinetnr    : 0..10
 * record type  : 11..12
 * remainder is data for record depending on type    : 13.. 700
 */
class PcFinetLineData {
    private String pcFinetNr;
    private int recordType;
    private String recordTypeData;

    public PcFinetLineData(String pcFinetLineData) {
        pcFinetNr = pcFinetLineData.substring( 0, 11 );
        recordType = Integer.parseInt( pcFinetLineData.substring( 11, 13 ) );
        recordTypeData = pcFinetLineData.substring( 13 );
    }

    //        distinctByKey
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public String getPcFinetNr() {
        return pcFinetNr;
    }

    public int getRecordType() {
        return recordType;
    }

    public String getRecordTypeData() {
        return recordTypeData;
    }
}
