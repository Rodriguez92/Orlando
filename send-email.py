#!/usr/bin/env python

from smtplib import SMTP
import sys

mailFrom    = 'ing.rocioflores@gmail.com'
mailSubject = sys.argv[1] + '\n'
mailTo      = sys.argv[2]
mailBody    = ['Correo enviado desde la terminal de linux']

mensaje = ['From: ' + mailFrom, 'To: ' + mailTo, 'Subject: ' + mailSubject, '\r\n'.join(mailBody)]
mensaje = '\r\n'.join(mensaje)

s = SMTP('smtp.gmail.com')
s.starttls() # Si usas TLS
s.ehlo()
s.login('ing.rocioflores','') #
s.sendmail(mailFrom, mailTo, mensaje)
s.quit() 
