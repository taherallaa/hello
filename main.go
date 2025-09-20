package main

import (
	"fmt"
	"log"
	"os"

	"github.com/taherallaa/greetings"
)

func main() {
	log.SetPrefix("greetings: ")
	log.SetFlags(0)

	names := os.Args[1:]
	if len(names) == 0 {
		log.SetPrefix("names: ")
		log.Fatal("you should provide one name at least")
	}

	msgs, err := greetings.Hellos(names...)
	if err != nil {
		log.Fatal(err)
	}

	for name, msg := range msgs {
		fmt.Printf("%s: %s\n", name, msg)
	}
}
