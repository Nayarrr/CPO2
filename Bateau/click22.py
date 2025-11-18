#!/usr/bin/env python
import click

@click.command()
@click.option('--greeting', help = 'How to greet?')
@click.option('--name', default ='Tammy', help = 'Who to greet?')
def greet(greeting, name):
    print(f'{greeting} {name}')

if __name__ == '__main__':
    greet()
