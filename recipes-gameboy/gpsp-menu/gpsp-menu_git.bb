SUMMARY = "gpSP/Gearboy frontend for AsteroidOS"
HOMEPAGE = "https://github.com/MagneFire/gpsp-menu.git"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "git://github.com/MagneFire/gpsp-menu.git;protocol=https"
SRCREV = "${AUTOREV}"
PR = "r1"
PV = "+git${SRCPV}"
S = "${WORKDIR}/git"
inherit qmake5

FILES_${PN} += "/usr/share/icons/asteroid/"
FILES_${PN} += "/usr/share/translations/"

DEPENDS += "qml-asteroid libsdl2 qttools-native qtdeclarative-native"
RDEPENDS_${PN} += "qtsensors libsdl2 qtsensors-qmlplugins qtsensors-plugins gpsp"

do_install_append() {
    install -d ${D}/usr/share/icons/asteroid/
    cp ${S}/i18n/gameboy.svg ${D}/usr/share/icons/asteroid/

    lrelease -idbased ${S}/i18n/${PN}.*.ts
    install -d ${D}/usr/share/translations/
    cp ${S}/i18n/${PN}.*.qm ${D}/usr/share/translations/
}