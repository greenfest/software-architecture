interface Builder {
    buildPart1(): void;
    buildPart2(): void;
    getResult(): Product;
}

class ConcreteBuilder implements Builder {
    private product: Product = new Product();

    buildPart1(): void {
        this.product.addPart("Part 1");
    }

    buildPart2(): void {
        this.product.addPart("Part 2");
    }

    getResult(): Product {
        return this.product;
    }
}

class Product {
    private parts: string[] = [];

    addPart(part: string): void {
        this.parts.push(part);
    }

    showParts(): void {
        console.log(`Product parts: ${this.parts.join(', ')}`);
    }
}

class Director {
    construct(builder: Builder): void {
        builder.buildPart1();
        builder.buildPart2();
    }
}

// Пример использования Builder
const builder = new ConcreteBuilder();
const director = new Director();

director.construct(builder);

const product = builder.getResult();
product.showParts();
