# Spring Boot Apache Kafka Implementation

This module contains the implementation of Apache Kafka.

### Libraries

- Spring Boot
- Apache Kafka

# Kafka

Apache Kafka bir message bus uygulamasıdır.

Bilgiler kafkaya event olarak gönderilir. Event’lar okunarak işlemler yapılır.

**Broker** - Her kafka cluster 1 veya daha fazla broker’dan oluşur.  Her broker birbirine bağlı olarak çalışır. Her broker’ın kendine özel kimlik numarası vardır.  Kafkaya gönderilen mesajlar saklanır ve işlenir. Veriler broker’larda harddiskte saklanır. Mesajlar broker’larda saklanır.

**Zookeeper** - Açık kaynak kodlu bir yazılım ve Kafka bunu broker’ları yönetmek için kullanır. Veriler burada saklanmaz.

**Producer** - Kafkaya veri yazar.

**Consumer** - Kafka’dan veri okur.

Test amaçlı birer broker ve zookeeper yeterli ancak gerçek bir uygulamada birden fazla tek sayılardan oluşan adette olmalıdır. Split Brain ve Replication hatalarının önüne geçmek için.

## **Replication**

bir verinin istenilen sayıda çoğaltılması.

5 broker olsun Replication da 3 olsun. 1 veri 3 ayrı broker’a yazılsın. Bir veri daha gelsin o da 3 ayrı broker’a yazılsın. Broker’lardan sırayla çökmeye başladığını düşünelim. 3’ten az sayıda broker olduğunda replication yapamayacağından hata oluşur.

Burada broker sayısı Replication sayısına eşit ya da daha büyük olması gerekiyor.

## **Split Brain**

iki broker’ın bağlantısı koptuğunda veriler yine de işlemeye devam eder. Veri akışları sürerken broker’lar arası bağlantı problemi çözülür ve broker’lar senkron olmak ister. Bu sefer hangi verinin güncel hangisinin doğru olduğu soruna sprint brain diyoruz.

Split brain sorununu çözmek için Quorum - Bir topluluğun geçerli olabilmesi için herhangi bir zamanda bulunması gereken asgari üye sayısı. Bir toplantının başlayabilmesi için asgari kaç kişinin olması gerektiği örneği verilebilir.

Quorum sayısı **server sayısı /2 +1** olmalıdır.

Örn; 7 server olursa quorum 5 olur ve 2 çöken server’ı tolere edebilir.

## Broker / Topic / Partition

Kafka verileri broker’lar içindeki topic’lerde tutar. Her topic’in kendine ait bir ismi vardır. Topic’lerin içinde de partition’lar vardır. Her topic için partition sayısını siz belirliyorsunuz. Her partition’un bir numarası vardır. Veriler partition’a gönderilen sırayla yazılır. Yazılan bir veri bir daha değiştirilemez. Veriler HDD’e saklanır. Veriler sonsuza kadar saklanmaz. Kafka saklama config’i sunuyor. Zaman bazlı (default 7 gündür) ve veri büyüklüğü bazlı. Örneğin bir topic içindeki veri 100gb sınırlama yapılırsa ve bu sınırı geçerse veriler eskilerden başlanarak silinilir. Çok tercih edilmez bu yöntem. Zaman bazlı veri saklaması daha sık kullanılır.

# Partition Kullanımı

Verilere topic’lere gönderirken partition key’ler belirleyebiliriz. Bu record key oluyor. record key belirlemezsek veriler partition’lara round-robin yöntemiyle farklı partition’lara sırasıyla yazılır. 3 farklı data gönderelim, ilk mesaj partition1’e ikincisi partition2’ye gidecek şekilde sırayla yazılır. Burda bir mesaj 3 partition’a aynı anda gitmez.

Aggregation ve sorting yapabilmek için partition’lara veriler record.key ile gönderilmelidir.

Bir topic’te sadece 1 partition olsaydı o zaman parallelism yapamazdık. Partition sayısı arttıkça parallelism yapma olanağımız artıyor ve performans daha da artıyor.

## Partition Replication

Her bir broker’da replication oluştuğunda yeni bir veriyi biz çoğaltılmış n tane partition’a yazmaya gerek duymayız. Burada her partition’ın replication kopyalarından biri **leader partition** olarak kullanılır. Veriler her zaman leader partition’a yazılır. Yazdığımız veriler diğer broker’lardaki partition’lara veriyi senkron eder. Leader partition çökerse kafta otomatik olarak partition’lardan birini leader partition olarak seçer (**leader partition election**).

# Producer Acknowledgment

**acks = 0** en hızlı ve en riski olan seçenek. Verilerin kaybolma potansiyeli yüksek.

- Mesajı kafkaya gönder ve cevabı beklemeden devam et.

**acks = 1** orta derecede hızlı ve güvenli. Mesajın kaybolma şansı çok az.

- Mesajı kafkaya gönder ve leader yazana kadar bekle.

**acks = -1,** all en yavaşı ve en güvenlisi. Mesajın kaybolma şansı yok.

- Mesajı Kafkaya gönder leader’a ve leaderın da diğer partition’lara yazmasını bekle.

# Kafkadan Veri Okuma

partition 0 / Consumer 1

| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
1. Event oku (offset 0)
2. İşlemini yap
3. Commit et (offset 0)
4. Sonraki offset 1 olur. Offset bilgisi zookeeper’a yazılır.
5. Event oku (offset 1)
6. commit et (offset 1)
7. Sonraki offset 2 olur

Uygulamayla bağlantı bir şekilde çökse ve bağlanamasa sonraki bağlantıda kalan offset’ten devam edebilir. Mesajlar tek tek okunup tek tek de commit edilebilir ya da tüm mesajlar okunup tek sefer de commit edilebilir.

### **At Most Once - En fazla Bir Kere**

Consumer 1

| Kafka Reader  ———>  Process ———> Save to DB |
| --- |

Mesaj okunur, Commit edilir ve process işlemine tabii tutulur. Tam o esnada bir hata oluştuğunda DB’ye kaydedemeden mesaj kaybolur. Çünkü sonraki çalışmada offset bilgisi 1 artmıştır.

### **At Least Once - En Az Bir Kere** ✔

Mesaj okunur, process işlemine dahil edilir, DB’ye kaydedilir ve tüm işler bittikten sonra commit edilir. Mesajın hatasız bir şekilde işlediğimizden emin oluruz. Uygulamanın herhangi bir yerinde hata olduğunda commit edilmediği için. okuyucu yine o offset üzerinden okumaya başlayacaktır. Aynı mesaj birden fazla okunup işlenebilir. En çok tercih edilen yöntemdir.

### Exactly Once - Tam Bir Kere

Mesaj okunur. Mesaj okur okunmaz bir adet transaction oluşturulur. Transaction işlemi sadece 1 kere yapıyor. Transaction içinde önceden yapılan işlemler tekrarlanmıyor. Mesaj gitse bile hala bu transaction içinde olduğu için kaybolmuyor. Performans açısından oldukça etkilidir ve kullanılması gerektiğinde kullanılması önerilir. **Kafka Streams** ve **Apache Flink** gibi uygulamalar bu işlemleri yapar.

# Consumer Group

Bir topic içerisinde 4 tane partition olsun. Consumer group içinde de sadece 1 adet consumer olsun. O zaman consumer 1 aynı anda tüm partition’ları okuyabilir. Ancak bu çok performanslı olmayabilir. 1 adet daha consumer eklendiğinde kafka consumer’lara 2 şer tane partition okuyacak şekilde bölüştürür. 1 tane daha consumer eklenirse ona da paylaştırılır. Ve nihayetinde 4 tane consumer olduğunda her partition 1 adet okuyucuyu karşılayacak şekilde performanslı bir şeklide çalışır.

Bir topic’i birden fazla consumer group okuyabilir. İsimleri birbirinden farklı olduğu sürece sorun olmaz o da ayrıca okuma işlemini gerçekleştirebilir.

# Local’de Kafka

Öncelikle zookeeper’ı çalıştırmamız gerekiyor. Bir config dosyası göstermemiz gerekiyor.

```bash
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

Sonrasında Kafka’yı çalıştırıyoruz. Burda da server.properties’ı config olarak gösteriyoruz.

```bash
./bin/kafka-server-start.sh config/server.properties
```

Burda 1 adet broker çalışmakta. İkinci bir server ayağa kaldırmak için server.properties dosyasının bir kopyasını oluşturuyoruz ve ona da server1.properties diyelim. Bu kopyada değişecek alanlar;

broker.id = 1, listener=PLAINTEXT://:9093 (comment out edilecek), log.dirs=/tmp/kafka1-logs

```bash
./bin/kafka-server-start.sh config/server1.properties
```

Server’lar ayağa kalktı. **bin** altında ./kafka-topic.sh ile komutların listesini görebiliyoruz.

Bu listede **—bootstrap-server** parametresi verilmesi zorunlu parametrelerden biridir. Hangi kafka broker üzerinden bunu yapmak istediğimizi belirtiyoruz.

```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic topic1
```

bir topic daha oluşturacağız. Bu sefer partitions ve replication bilgilerini kendimiz vereceğiz. replication’a 2 diyoruz çünkü sadece 2 adet kafka broker’ımız var.

```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --partitions 10 --replication-factor 2 --create --topic topic10
```

Bir topic hakkında bilgi almak için **describe** parametresini kullanırız.

```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic topic10
```

oluşturduğumuz topic’i silmek için de **delete** parametresini kullanıyoruz.

```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic topic1
```

tüm topic’leri listelemek için **list** komutu:

```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --list
```

Artık topic hazır, şimdi mesaj gönderip mesaj okuyalım.

```bash
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --from-beginning --topic topic10
```

boş dönebilir çünkü içinde mesaj yok. bir mesaj gönderelim.

```bash
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic topic10
```

sonrasında her enter’a basıldığında eklenen mesaj gönderiliyor.

consumer gruplarının listelenmesi için de;

```bash
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
```

consumer group için detaylı bilgi elde etmek için;

```bash
./kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group console-consumer-25734
```

burada her partition için ayrı ayrı bilgiler gösterilir.

Detaylarda CURRENT-OFFSET şu an consumer tarafından okunmuş ve commit edilmiş en son offset’i gösterir. LOG-END-OFFSET ise partition içerisindeki en son okunmuş veya okunmamış farketmeksizin en son offset numarasını gösterir. CURRENT-OFFSET - ile gösterilirse demek ki LOG-END-OFFSET ile aynı olduğunu anlıyoruz. Bu tüm mesajların okunduğunu ve commit’lendiğini anlıyoruz. Aynı listede LAG göreceğiz bu da partition’a yazılan mesajların sayısının okunma sayısına olan farkını gösterir. Örneğin yazarken saniyede 1000 mesaj yazıp okurken 998 mesaj okuyorsak, her saniye okunmayan mesaj sayısı 2 artar. Burada LAG saniyede 2 artar. LAG süresi önemli çünkü realtime okuma için bir fark oluşturmasında bir engeldir. Geriden gelme olasılığı vardır.