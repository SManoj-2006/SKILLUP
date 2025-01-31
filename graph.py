class Graph:
    def __init__(self):
        self.adjacency_list = {}
    
    def add_vertex(self, vertex):
        if vertex not in self.adjacency_list:
            self.adjacency_list[vertex] = []
            
    def add_edge(self, source, destination):
        self.add_vertex(source)
        self.add_vertex(destination)
        self.adjacency_list[source].append(destination)
    
    def remove_edge(self, source, destination):
        if source in self.adjacency_list:
            if destination in self.adjacency_list[source]:
                self.adjacency_list[source].remove(destination)
            
    def get_neighbors(self, vertex):
        return self.adjacency_list.get(vertex, [])
    
    def has_edge(self, source, destination):
        return source in self.adjacency_list and destination in self.adjacency_list[source]
        
    def get_vertices(self):
        return list(self.adjacency_list.keys())

if __name__ == "__main__":
    graph = Graph()
    graph.add_edge(0, 1)
    graph.add_edge(0, 2) 
    graph.add_edge(1, 2)
    graph.add_edge(2, 0)
    graph.add_edge(2, 3)
