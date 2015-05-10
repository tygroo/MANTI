start http://localhost:8080/test.xhtml

echo off
set USER_DIR=%HOMEDRIVE%%HOMEPATH%
set CURRENT_DIR=%~dp0
set NOM_WAR_LOCAL=NULL

for /r %CURRENT_DIR% %%i in (*.war) do set NOM_WAR=%%~nxi
for /r %USER_DIR%\MANTI %%j in (*.war) do set NOM_WAR_LOCAL=%%~nxj
echo Nom fichier executable : %NOM_WAR%
echo Nom fichier executable en local : %NOM_WAR_LOCAL%
MKDIR %USER_DIR%\MANTI
echo on
if NOT %NOM_WAR%==%NOM_WAR_LOCAL% COPY %CURRENT_DIR%%NOM_WAR% %USER_DIR%\MANTI\%NOM_WAR% && DEL %USER_DIR%\MANTI\%NOM_WAR_LOCAL%

java -Ddb.path=%CURRENT_DIR% -jar %USER_DIR%\MANTI\%NOM_WAR%






