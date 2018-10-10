@echo off
setlocal enabledelayedexpansion
for /f "delims=" %%i in ('dir /b/a-d/s %cd%\*.less')  do (
    set FILE_NAME=%%~ni
    start cmd /c "lessc !FILE_NAME!.less ../css/!FILE_NAME!.css"
    echo !FILE_NAME!.css in build success!
)
pause