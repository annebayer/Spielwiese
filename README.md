# Wissenswertes

## Allgemeines

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

  
### Annotations und Validierungen
+ Im Ordner annotationandvalidation ist ein Beispiel, wie man eigenen Annotationen macht und diese validiert
+ Selbstgeschriebene Annotationen im Allgemeinen durchsuchen nur den Code nach diesen und machen nichts, durch Frameworks, Validierungen, ... passiert dann damit etwas
+ Als Beispiel für Retention.SOURCE wäre "@ToDo", mit einem weiteren Tool könnte man die Todos dann sammeln. Source Annotationen fliegen beim Kompilieren raus.