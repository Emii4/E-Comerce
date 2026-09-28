@echo off
chcp 65001 >nul
cd /d "%~dp0"
echo.
echo ========== LOJA ESCOLA ==========
echo O servidor ficara nesta janela. NAO feche enquanto usar a loja.
echo.
powershell.exe -NoProfile -ExecutionPolicy Bypass -File "%~dp0ferramentas\iniciar_windows.ps1"
if errorlevel 1 echo ERRO AO INICIAR. Consulte o README_COMECE_AQUI.md.
echo.
pause
