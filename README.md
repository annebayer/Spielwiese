# Wissenswertes

## Allgemeines Projekt
### Neues Projekt in GitHub anlegen
+ Auf GitHub anmelden und neues Repository erstellen
+ Projekt in z.B. IntelliJ initialisieren
  + git init 
  + git remote add origin <URL-deines-GitHub-Repositories>
  + git add .
  + git commit -m "Initial commit"
  + git push -u origin main (oder master oder auf welchen Branch auch immer)
    + Falls man noch nicht angemeldet ist, muss das hier auch passieren 

### .gitignore
+ Steht normalerweise im Root-Verzeichnis
+ Verwendung von "."
  + ohne Punkt wird alles davon ignoriert z.B. idea ignoriert den Ordner idea und .idea
  + mit einem führenden Punkt wird nur das versteckte Verzeichnis ignoriert (z.B. .idea ignoriert nicht idea)
+ Verwendung von "/"
  + Ignoriert jedes Verzeichnis oder jede Datei namens logs, überall im Projekt
  logs
  + Ignoriert nur das logs-Verzeichnis im Stammverzeichnis des Repositories
  /logs
  + Ignoriert alle Verzeichnisse namens logs, aber keine Dateien namens logs
  logs/
+ Verwendung von "!"
  + macht Ausnahmen vom Ignorieren. In zu ignorierenden Ordnern kann ein !file oder !ordner wieder hinzufügen  

## Allgemeines Programmieren
### Maven
+ Maven ist ein Build-Management- und Projektmanagement-Tool. Es automatisiert den Build-Prozess von Java-Anwendungen.
+ POM (Project Object Model) ist eine XML-Datei, die die Konfigurationen des Projektes definiert.
  + Projektstruktur: Legt Standardverzeichnisstruktur fest, die Quellcode, Ressourcen, Tests und andere Komponenten erleichtert
  + Abhängigkeitsmanagement: externe Bibliotheken können mit der Pom zentral definiert werden und maven bindet diese dann direkt ein
  + Build-Lifecycle: Hat vordefinierten Satze von Lebenszyklen (phases), die den Build-Prozess steuern, von der Initialisierung, bis zur Auslieferung.
+ Es wird bei mvn install ein neues target angelegt, es wird keine dependencyInjection oder ähnliches da mitgemacht. Das wird alles im ApplicationContext (eigenständigen Container) geregelt
+ Befehle
  + mvn install: Geht diese Schritte durch: validate, compile, test, package, install
  + mvn validate: Validiert, ob Projekt korrekt und alle notwendigen Infos da sind
  + mvn compile: Kompiliert den Quellcode
  + mvn test: führt die Tests aus
  + mvn package: Verpackt den kompillierten Code in eine jar- oder war-Datei
  + mvn install: Installiert das erstellte Paket in das lokale Maven-Repository, es kann also lokal auf dem Rechner von anderen Projekten genutzt werden, wenn Abhängigkeiten bestehen
  + mvn verify: lässt alle Checks laufen, die das package prüfen, dass sie valide sind und die Qualität stimmt
  + mvn deploy: in einer integration oder release Umgebung, kopiert das finale package zu einem remote repository, um es mit anderen Entwicklern oder Projekte zu teilen
  + mvn clean: entfernt die aus früheren builds gebauten Artefakte
  + mvn site: generiert site Dokumente für das Projekt
+ Profile:
  + Man kann unterschiedliche Profile definieren, die unterschiedliche Anforderungen im Build-Prozesse erfüllen
  + Üblich sind Entwicklungs-, Test- oder Produktionsumgebungen
+ Scopes
  + Abhängigkeiten, wann welche Bibliothek erforderlich ist (bsp. compile, test, provided, runtime), die Abhängigkeiten (Bibliotheken) werden nur dann geholt
+ Repositories
  + das lokale Repository ist auf dem Computer gespeichert und darauf können andere Programme lokal zugreifen
+ Versionsverwaltung
  + Es werden Versionsverwaltungen genutzt, dass man fix angeben kann, welche Version man möchte ("version")
  
### Spring
#### Profile
Profile in Spring ermöglichen es, verschiedene Konfigurationen und Bean-Definitionen basierend auf der Umgebung zu aktivieren. 
Zum Beispiel unterschiedliche DB, Caching, ... können darüber gesetzt werden (dev/test/prod)
+ Profile in Spring können über application-{profile}.properties angelegt werden
+ In IntelliJ kann das Profil über die Configurations (oben, neben dem starten/stoppen/debuggen) gesetzt werden, bei der jar mit -Dspring.profile.active={profile}
+ Die application.properties bildet den Fallback, das wird genommen, wenn es nicht über ein explizites Profil gesetzt wird
+ Mit @Profile("{profile}") kann die Bean-Initialisierung gesteuert werden (z.B. ein Service kann unterschiedlich definiert sein für die unterschiedlichen Profile)
+ Logging Level oder Konfigurationen können unterschiedlich sein
+ Security-Konfigurationen können angepasst werden
+ Integration von verschiedenen Systemen kann gesteuert werden
+ FeatureFlags sind möglich
+ Pipeline und CI können individualisiert werden
+ Tests können angepasst werden
+ Die Cloud-Umgebung kann ggf. angepasst werden


## Speziellere Sachen
### Annotations und Validierungen
+ Im Ordner annotationandvalidation ist ein Beispiel, wie man eigenen Annotationen macht und diese validiert
+ Selbstgeschriebene Annotationen im Allgemeinen durchsuchen nur den Code nach diesen und machen nichts, durch Frameworks, Validierungen, ... passiert dann damit etwas
+ Als Beispiel für Retention.SOURCE wäre "@ToDo", mit einem weiteren Tool könnte man die Todos dann sammeln. Source Annotationen fliegen beim Kompilieren raus.