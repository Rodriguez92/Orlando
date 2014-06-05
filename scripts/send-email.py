#!/usr/bin/env python

from smtplib import SMTP
import sys

mailFrom    = 'ing.diegorod@gmail.com'
mailSubject = sys.argv[1] + '\n'
mailTo      = sys.argv[2]
mailBody    = ['Correo enviado desde terminal de linux con script']

mensaje = ['From: ' + mailFrom, 'To: ' + mailTo, 'Subject: ' + mailSubject, '\r\n'.join(mailBody)]
mensaje = '\r\n'.join(mensaje)

s = SMTP('smtp.gmail.com')
s.starttls() # Si usas TLS
s.ehlo()
s.login('ing.diegorod','') #
s.sendmail(mailFrom, mailTo, mensaje)
s.quit() 
