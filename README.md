# WebProgramiranje-
projekat za web programiranje
# Streaming sportskih prenosa

## 1. Opis projekta

**Streaming sportskih prenosa** je web aplikacija razvijena korištenjem Spring Boot frameworka, Thymeleaf tehnologije i Java programskog jezika. Aplikacija omogućava pregled sportskih utakmica, pregled klubova koji učestvuju u utakmicama i upravljanje demo statusom sportskog prenosa.

Cilj projekta je demonstrirati primjenu MVC arhitekture, povezivanje dva modela, prikaz podataka na HTML stranicama i implementaciju jednostavne interaktivne akcije.

Aplikacija koristi podatke definisane u memoriji, bez potrebe za povezivanjem na bazu podataka.

## 2. Autori projekta

- **Studentica 1:** Berina Helvida
- **Studentica 2:** Lamija [prezime dopuniti]

## 3. Korištene tehnologije

- Java
- Spring Boot
- Spring MVC
- Thymeleaf
- HTML5
- CSS
- Maven

## 4. Modeli i njihova povezanost

Aplikacija sadrži dva modela: `Match` i `Team`.

### Model Match

Predstavlja sportsku utakmicu i sadrži sljedeće atribute:

- `id` – jedinstveni identifikator utakmice
- `title` – naziv utakmice
- `startTime` – datum i vrijeme početka utakmice
- `streamUrl` – URL povezan sa demo prenosom
- `streaming` – označava da li je demo prenos pokrenut
- `teams` – lista klubova koji učestvuju u utakmici

### Model Team

Predstavlja sportski klub i sadrži sljedeće atribute:

- `id` – jedinstveni identifikator kluba
- `name` – naziv kluba
- `city` – grad iz kojeg klub dolazi
- `sport` – sport kojim se klub bavi
- `matches` – lista utakmica u kojima klub učestvuje

### Relacija između modela

Između modela `Match` i `Team` ostvarena je relacija **N:N (više-prema-više)**.

Jedna utakmica može sadržavati više klubova, dok jedan klub može učestvovati u više utakmica. Povezanost modela prikazana je na stranicama aplikacije.

## 5. Funkcionalnosti aplikacije

Aplikacija omogućava:

- Pregled liste sportskih utakmica.
- Pregled liste sportskih klubova.
- Prikaz klubova koji učestvuju u pojedinoj utakmici.
- Prikaz utakmica u kojima učestvuje određeni klub.
- Otvaranje stranice za upravljanje demo prenosom.
- Pokretanje i zaustavljanje demo prenosa promjenom statusa utakmice.
- Prikaz poruke o uspješno izvršenoj akciji.

**Napomena:** Pokretanje i zaustavljanje prenosa služi za demonstraciju funkcionalnosti aplikacije. Aplikacija trenutno ne emituje stvarni video sadržaj.

## 6. MVC arhitektura

Projekat koristi MVC (Model-View-Controller) arhitekturu.

- **Model:** klase `Match` i `Team` predstavljaju podatke aplikacije.
- **View:** Thymeleaf HTML stranice prikazuju podatke korisniku.
- **Controller:** klasa `AppController` obrađuje HTTP zahtjeve i povezuje modele s prikazima.
- **DemoData:** komponenta koja sadrži početne podatke u memoriji.

## 7. Struktura projekta

```text
src/
└── main/
    ├── java/
    │   └── org/example/streamingsportskihprenosa/
    │       ├── StreamingSportskihPrenosaApplication.java
    │       ├── Models/
    │       │   ├── Match.java
    │       │   └── Team.java
    │       ├── data/
    │       │   └── DemoData.java
    │       └── contoller/
    │           └── AppController.java
    └── resources/
        ├── templates/
        │   ├── matches.html
        │   ├── teams.html
        │   └── streaming.html
        └── application.properties
```

## 8. Rute aplikacije

| HTTP metoda | Ruta | Opis |
|---|---|---|
| GET | `/` | Preusmjeravanje na listu utakmica |
| GET | `/matches` | Prikaz svih utakmica |
| GET | `/a` | Alternativni prikaz liste utakmica |
| GET | `/teams` | Prikaz svih klubova |
| GET | `/b` | Alternativni prikaz liste klubova |
| GET | `/matches/action/{id}` | Prikaz stranice za demo prenos |
| POST | `/matches/action/{id}` | Pokretanje ili zaustavljanje demo prenosa |

## 9. Pokretanje aplikacije

Za pokretanje aplikacije potrebno je:

1. Otvoriti projekat u IntelliJ IDEA.
2. Sačekati da Maven preuzme potrebne zavisnosti.
3. Pokrenuti klasu `StreamingSportskihPrenosaApplication`.
4. Otvoriti web preglednik.
5. Posjetiti adresu:

```text
http://localhost:8080/
```

Aplikacija koristi unaprijed definisane podatke i ne zahtijeva bazu podataka.

## 10. Screenshotovi aplikacije

Na ovom mjestu potrebno je dodati screenshotove aplikacije nakon pokretanja.

Preporučeni screenshotovi:

1. Lista sportskih utakmica (`/matches`).
2. Lista sportskih klubova (`/teams`).
3. Stranica za upravljanje demo prenosom (`/matches/action/1`).

Screenshotovi se mogu dodati u repozitorij, na primjer u folder `screenshots`, a zatim prikazati u ovom dokumentu pomoću Markdown sintakse:

```markdown
![Lista utakmica](screenshots/utakmice.png)

![Lista klubova](screenshots/klubovi.png)

![Demo prenos](screenshots/prenos.png)
```

## 11. Zaključak

Projekat demonstrira osnovnu primjenu Spring Boot frameworka i MVC arhitekture kroz aplikaciju za pregled sportskih utakmica i klubova. Implementirani su povezani modeli, prikaz podataka pomoću Thymeleaf tehnologije, GET i POST rute te jednostavna interaktivna akcija za promjenu statusa demo prenosa.

Aplikacija predstavlja osnovu za buduće proširenje funkcionalnosti, kao što su korisnički nalozi, baza podataka, raspored utakmica i integracija stvarnog video streaminga.
