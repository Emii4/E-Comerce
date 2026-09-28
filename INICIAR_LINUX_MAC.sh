#!/usr/bin/env bash
set -e
cd "$(dirname "$0")"
if ! command -v java >/dev/null || ! command -v javac >/dev/null; then
    echo 'Instale Java JDK 17 ou superior antes de continuar.'; exit 1
fi
if ! command -v mvn >/dev/null; then
    echo 'Instale Maven ou execute o projeto no editor configurado.'; exit 1
fi
mvn spring-boot:run
