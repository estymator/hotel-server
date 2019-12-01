# hotel-server


## Execute

```bash
./gradlew bootRun
```

## Build jar

```bash
./gradlew build
```

## Endpoints

### /register

-imie 

-nazwisko

-telefon

-email

-login

-haslo

bez walidacji, haslo szyfrowane bcrypt

### /login  
-login 

-haslo

bez walidacji, haslo szyfrowane bcrypt

### /logout


### /hotel/add

-nazwa

-adres

-email

-telefon

-id_admina(bez walidacji)

### /hotel/all

zwraca wszystkie hotele zapisane w bazie

### /personel/add

-imie

-nazwisko

-email

-telefon

-idHotelu(bez walidacji)

### /personel/delete

-id_personelu


### /personel/id

-id_personelu/idHotelu - zwraca osobe o danym id/osoby pracujące w hotelu o danym id


### /personel/all


### /pokoj/add

-ilosc_osob

-standart

-status

-idHotelu

###
## License
[MIT](https://choosealicense.com/licenses/mit/)
