@echo off
setlocal enabledelayedexpansion
set theDate=%date:~0,4%%date:~5,2%%date:~8,2%
echo now day:!theDate!
for /f "delims=" %%i in ('dir /b/a-d/s %cd%\*.less')  do (
    set FILE_NAME=%%~ni
    start cmd /c "lessc !FILE_NAME!.less ../css/!FILE_NAME!.css"
    echo !FILE_NAME!.css in build success!
)
echo file length:!file_length!
pause