package main
import "testing"
import "fmt"
import "time"

func TestSample(t *testing.T) {
    fmt.Println("Testing")
    time.Sleep(20000 * time.Millisecond)
    // t.Fatal("Ooops...")
    fmt.Println("Testing Done!")
}
